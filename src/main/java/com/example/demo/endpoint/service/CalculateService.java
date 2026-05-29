package com.example.demo.endpoint.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public double add(double a, double b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("a and b should be positive");
        }
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("divide with zero impossible");
        }
        return a / b;
    }
}

