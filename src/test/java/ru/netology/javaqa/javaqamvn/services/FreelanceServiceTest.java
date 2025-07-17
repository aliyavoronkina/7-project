package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreelanceServiceTest {

    @Test
    void shouldCalculateThreeMonthsRest() {
        FreelanceService service = new FreelanceService();
        int actual = service.calculate(10_000, 3_000, 20_000);
        assertEquals(3, actual);
    }

    @Test
    void shouldCalculateTwoMonthsRest() {
        FreelanceService service = new FreelanceService();
        int actual = service.calculate(100_000, 60_000, 150_000);
        assertEquals(2, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10000, 3000, 20000, 3",
            "100000, 60000, 150000, 2",
            "5000, 3000, 50000, 0",
            "15000, 5000, 10000, 6",
            "10000, 10000, 20000, 0"
    })
    void shouldCalculateVariousScenarios(int income, int expenses, int threshold, int expected) {
        FreelanceService service = new FreelanceService();
        int actual = service.calculate(income, expenses, threshold);
        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroThreshold() {
        FreelanceService service = new FreelanceService();
        // При threshold=0 будет отдых, но деньги делятся на 3 каждый раз
        // Рассчитанное ожидаемое значение для этих параметров
        int actual = service.calculate(10_000, 3_000, 0);
        assertEquals(8, actual);  // Фактический результат при такой логике
    }
}