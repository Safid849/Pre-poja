package com.example.demo.conf;

import com.example.demo.endpoint.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        this.calculateService = new CalculateService();
    }

    @Test
    void add_ShouldReturnSum_WhenBothNumbersArePositive() {
        double a = 5.5;
        double b = 4.5;

        double result = calculateService.add(a, b);

        assertEquals(10.0, result, "L'addition de 5.5 et 4.5 devrait donner 10.0");
    }

    @Test
    void add_ShouldThrowIllegalArgumentException_WhenFirstNumberIsNegative() {
        double a = -5.0;
        double b = 10.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculateService.add(a, b)
        );

        assertEquals("a and b should be positive", exception.getMessage());
    }

    @Test
    void add_ShouldThrowException_WhenSecondNumberIsNegative() {
        double a = 5.0;
        double b = -0.1;

        assertThrows(IllegalArgumentException.class, () -> calculateService.add(a, b));
    }

    @Test
    void divide_ShouldThrowException_WhenDividingByZero() {
        double a = 10.0;
        double b = 0.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculateService.divide(a, b)
        );

        assertEquals("divide with zero impossible", exception.getMessage());
    }

    @Test
    void divide_ShouldReturnCorrectValue_WhenArgumentsAreValid() {
        double a = 10.0;
        double b = 4.0;

        double result = calculateService.divide(a, b);

        assertEquals(2.5, result);
    }
}