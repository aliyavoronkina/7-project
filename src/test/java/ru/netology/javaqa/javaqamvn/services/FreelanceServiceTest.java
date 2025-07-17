package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FreelanceServiceTest {

    @Test
    void shouldCalculateThreeMonthsRest() {
        FreelanceService service = new FreelanceService();
        int income = 10_000;
        int expenses = 3_000;
        int threshold = 20_000;

        int actual = service.calculate(income, expenses, threshold);
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateTwoMonthsRest() {
        FreelanceService service = new FreelanceService();
        int income = 100_000;
        int expenses = 60_000;
        int threshold = 150_000;

        int actual = service.calculate(income, expenses, threshold);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10000, 3000, 20000, 3",
            "100000, 60000, 150000, 2",
            "5000, 3000, 50000, 0",
            "15000, 5000, 10000, 6",
            "0, 3000, 20000, 0",
            "10000, 10000, 20000, 0"
    })
    void shouldCalculateVariousScenarios(int income, int expenses, int threshold, int expected) {
        FreelanceService service = new FreelanceService();
        int actual = service.calculate(income, expenses, threshold);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroThreshold() {
        FreelanceService service = new FreelanceService();
        int actual = service.calculate(10_000, 3_000, 0);
        Assertions.assertEquals(12, actual);
    }

    @Test
    void shouldHandleIncomeEqualsExpenses() {
        FreelanceService service = new FreelanceService();
        int actual = service.calculate(10_000, 10_000, 20_000);
        Assertions.assertEquals(0, actual);
    }
}