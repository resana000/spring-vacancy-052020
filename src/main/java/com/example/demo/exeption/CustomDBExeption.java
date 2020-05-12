package com.example.demo.exeption;

public class CustomDBExeption extends RuntimeException {
    public CustomDBExeption(String s) {
        super(s);
    }
}
