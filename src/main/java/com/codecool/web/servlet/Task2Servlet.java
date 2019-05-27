package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.database.Task1Db;
import com.codecool.web.dao.database.Task2Db;
import com.codecool.web.model.Task1Query;
import com.codecool.web.model.Task2Query;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.Task2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task2")
public class Task2Servlet extends AbstractServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            // először mindig coonectiont hozunk létre, ezt a connectiont átadjuk a task1dao nak
            Task2Dao task2Dao = new Task2Db(connection);
            Task2Service task2Service = new Task2Service(task2Dao);
            List<Task2Query> task2Result = task2Service.getResult();
            req.setAttribute("task2Result", task2Result);
            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numberOfProducts = Integer.parseInt(req.getParameter("numberOfProducts"));
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new Task2Db(connection);
            Task2Service task2Service = new Task2Service(task2Dao);
            List<Task2Query> task2Result = task2Service.getFilteredResult(numberOfProducts);
            req.setAttribute("task2Result", task2Result);
            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
