package com.neoflex.vacation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static com.neoflex.vacation.utils.Calculator.calculateVacation;

@SpringBootTest
@AutoConfigureMockMvc
class AppTest {

	@Test
	void calculateVacationTest() {
		var averageSalary = 150000;
		var vacationDays = 28;
		var expected = 143344.71;
		var actual = calculateVacation(averageSalary, vacationDays);
		assertEquals(expected, actual);
	}

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void testCalculateDefault() throws Exception {
        mockMvc.perform(get("/calculate"))
                .andExpect(status().isOk());
    }

	@Test
    public void testCalculate() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=150000&vacationDays=28"))
                .andExpect(status().isOk());
    }

}
