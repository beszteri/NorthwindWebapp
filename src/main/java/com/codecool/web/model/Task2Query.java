package com.codecool.web.model;

public class Task2Query {
    int numberOfProducts;
    String Company;

    public Task2Query(int numberOfProducts, String company) {
        this.numberOfProducts = numberOfProducts;
        Company = company;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public String getCompany() {
        return Company;
    }
}
