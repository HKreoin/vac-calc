package com.neoflex.vacation.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.neoflex.vacation.utils.Calculator.calculateVacation;

@RestController
public final class CalculateController {

    @GetMapping(value = "calculate")
    public Map<String, Double> calculate(@RequestParam(defaultValue = "0") double averageSalary,
                                            @RequestParam(defaultValue = "0") int vacationDays) {
        var vacationPay = calculateVacation(averageSalary, vacationDays);
        return (Map.of("vacationPay", vacationPay));
    }
}
