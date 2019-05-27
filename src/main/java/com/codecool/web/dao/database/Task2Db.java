package com.codecool.web.dao.database;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task1Query;
import com.codecool.web.model.Task2Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task2Db extends AbstractDao implements Task2Dao {

    public Task2Db(Connection connection) {
        super(connection);
    }

    private Task2Query fetchQuery(ResultSet resultSet) throws SQLException {
        int numberOfProducts = resultSet.getInt("numberOfProducts");
        String company = resultSet.getString("company");
        return new Task2Query(numberOfProducts, company);
    }

    @Override
    public List<Task2Query> getResult() {
        List<Task2Query> queries = new ArrayList<>();
        String sqlString = "SELECT company_name AS Company, COUNT(product_name) AS Product FROM suppliers INNER JOIN products ON suppliers.supplier_id = products.supplier_id GROUP BY Company ORDER BY Product DESC, Company";
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
    public List<Task2Query> getFilteredResult(int product) {
        List<Task2Query> queries = new ArrayList<>();
        String sqlString = "SELECT company_name AS Company, COUNT(product_name) AS Product FROM suppliers INNER JOIN products ON suppliers.supplier_id = products.supplier_id WHERE Product = ? GROUP BY Company ORDER BY Product DESC, Company";
        try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
            statement.setInt(1, product);
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
