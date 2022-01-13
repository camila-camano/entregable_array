package com.example.arrayproducts.handle;

public class ProductoError extends Exception {
    private String message;

    public ProductoError(String message){
        super(message);
    }
}