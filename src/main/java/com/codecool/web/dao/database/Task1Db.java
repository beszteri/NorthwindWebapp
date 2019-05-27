package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task1Db extends AbstractDao implements Task1Dao {
    public Task1Db(Connection connection){
        super(connection);
    }

    private Task1Query fetchQuery(ResultSet resultSet) throws SQLException {
        String product = resultSet.getString("product");
        String company = resultSet.getString("company");
        return new Task1Query(product, company);
    }

    @Override
    public List<Task1Query> getResult() {
        List<Task1Query> queries = new ArrayList<>();
        String sqlString = "SELECT product_name AS Product, company_name AS Company FROM products INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id ORDER BY product, company";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString)){
            while(resultSet.next()){
                queries.add(fetchQuery(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return queries;
    }

    @Override
    public List<Task1Query> getFilteredResult(String company) {
        List<Task1Query> queries = new ArrayList<>();
        String sqlString = "SELECT product_name AS Product, company_name AS Company FROM products INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id WHERE company_name = ? ORDER BY product, company;";
        try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
            statement.setString(1, company);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    queries.add(fetchQuery(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }
}
