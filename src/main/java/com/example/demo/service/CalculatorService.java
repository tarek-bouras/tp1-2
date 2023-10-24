package com.example.demo.service;

public interface CalculatorService<T> {
    T add(T num1, T num2);
    T subtract(T num1, T num2);
    T multiply(T num1, T num2);
    T divide(T num1, T num2);
}
