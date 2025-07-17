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
    public int calculate (int income, int expenses, int threshold) {
        int count = 0;    // Счётчик месяцев отдыха
        int money = 0;     // Текущие накопления

        for (int month = 1; month <= 12; month++) {
            if (money >= threshold) {
                // Отдых: тратим `expenses`, затем уменьшаем остаток в 3 раза
                money -= expenses;
                money /= 3;
                count++;
            } else {
                // Работа: зарабатываем `income`, тратим `expenses`
                money += income - expenses;
            }
        }

        return count;
    }
}