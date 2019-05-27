package com.codecool.web.dao;

import com.codecool.web.model.Task1Query;

import java.util.List;

public interface Task1Dao {
    List<Task1Query> getResult();
    List<Task1Query> getFilteredResult(String company);
}
