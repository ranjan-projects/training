package com.example.testing.model;

public class Country {

    private boolean status;
    private String value;

    public Country(boolean status, String value) {
        this.status = status;
        this.value = value;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
