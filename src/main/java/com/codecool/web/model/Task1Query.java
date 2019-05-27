package com.codecool.web.model;

public class Task1Query {
    private String product;
    private String company;

    public Task1Query(String product, String company) {
        this.product = product;
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }
}
