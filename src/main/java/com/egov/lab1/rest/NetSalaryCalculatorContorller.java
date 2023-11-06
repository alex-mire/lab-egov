package com.egov.lab1.rest;

import com.egov.lab1.domain.Salary;
import com.egov.lab1.exceptions.BadRequestException;
import com.egov.lab1.rest.dto.SalaryDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.Document;
import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/salary")
@Validated
@RequiredArgsConstructor
public class NetSalaryCalculatorContorller {

    @Autowired
    private final NetSalaryCalculatorService netSalaryService;
    @Autowired
    private SalaryManagementService salaryManagementService;

    @PostMapping("/calculator/net")
    public ResponseEntity<SalaryDto> calcualte(@RequestBody SalaryDto salary) throws Exception {
        try {
            var salaryValue = Long.parseLong(salary.getSalary());
            var netSalary = netSalaryService.getNetSalary(salaryValue);
            salaryManagementService.saveSalary(netSalary);

            SalaryDto dto = new SalaryDto();
            dto.setSalary(netSalary.getNetSalary());
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            throw new BadRequestException("Trebuie sa introduceti un numar!");
        }
    }

    @GetMapping("/all")
    public List<Salary> getAllSalaries() {
        return salaryManagementService.getAllSalaries();
    }

}
