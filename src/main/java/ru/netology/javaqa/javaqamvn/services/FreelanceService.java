package ru.netology.javaqa.javaqamvn.services;

public class FreelanceService {

    /**
     * Рассчитывает количество месяцев отдыха в году.
     *
     * @param income    - доход за месяц (руб.)
     * @param expenses  - обязательные траты за месяц (руб.)
     * @param threshold - минимальная сумма для отдыха (руб.)
     * @return количество месяцев отдыха (от 0 до 12)
     */
    public int calculate(int income, int expenses, int threshold) {
        int count = 0;
        int money = 0;

        for (int month = 1; month <= 12; month++) {
            if (threshold == 0 || money >= threshold) {
                count++;
                money -= expenses;
                if (threshold > 0) { // Делаем деление только при положительном пороге
                    money /= 3;
                }
            } else {
                money += income - expenses;
            }
        }
        return count;
    }
}