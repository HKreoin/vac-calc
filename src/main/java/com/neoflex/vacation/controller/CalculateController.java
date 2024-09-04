package com.neoflex.vacation.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.neoflex.vacation.utils.Calculator.calculateVacation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Vacation", description = "Сервис для подсчета отпускных")
public final class CalculateController {

    @GetMapping(value = "calculate")
    @Operation(summary = "Расчет отпускных на основе средней зарплаты и количестве дней отпуска",
        responses = {@ApiResponse(description = "Сумма отпускных")})
    public Map<String, Double> calculate(@RequestParam(defaultValue = "0") double averageSalary,
                                            @RequestParam(defaultValue = "0") int vacationDays) {
        var vacationPay = calculateVacation(averageSalary, vacationDays);
        return (Map.of("vacationPay", vacationPay));
    }
}
