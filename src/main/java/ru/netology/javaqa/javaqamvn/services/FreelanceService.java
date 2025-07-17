package ru.netology.javaqa.javaqamvn.services;

public class FreelanceService {
    public int calculate(int income, int expenses, int threshold) {
        int count = 0;
        int money = 0;

        for (int month = 1; month <= 12; month++) {
            if (money >= threshold) {
                // Всегда вычитаем expenses и делим на 3, как в условии
                money -= expenses;
                money /= 3;
                count++;
            } else {
                money += income - expenses;
            }
        }
        return count;
    }
}