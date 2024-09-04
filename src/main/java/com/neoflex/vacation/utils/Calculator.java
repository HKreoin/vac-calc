package com.neoflex.vacation.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public static double calculateVacation(double averageSalary, int vacationDays) {
        double averageWorkingDays = 29.3;
        double value = averageSalary / averageWorkingDays * vacationDays;
        var result = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
