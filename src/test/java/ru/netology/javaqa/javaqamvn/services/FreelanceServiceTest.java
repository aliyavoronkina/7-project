package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreelanceServiceTest {

    @Test
    void shouldCalculateThreeMonthsRest() {
        FreelanceService service = new FreelanceService();
        int income = 10_000;
        int expenses = 3_000;
        int threshold = 20_000;

        int actual = service.calculate(income, expenses, threshold);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateTwoMonthsRest() {
        FreelanceService service = new FreelanceService();
        int income = 100_000;
        int expenses = 60_000;
        int threshold = 150_000;

        int actual = service.calculate(income, expenses, threshold);
        int expected = 2;

        assertEquals(expected, actual);
    }
}
