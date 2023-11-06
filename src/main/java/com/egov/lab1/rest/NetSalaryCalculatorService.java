package com.egov.lab1.rest;

import com.egov.lab1.domain.Salary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NetSalaryCalculatorService {

    public Salary getNetSalary(Long grossSalary) {
        var cas = calculateCas(grossSalary);
        var cass = calculateCass(grossSalary);
        var tax = calculateTax(grossSalary - cas - cass);

        var salary = new Salary();
        salary.setCas(cas.toString());
        salary.setCass(cass.toString());
        salary.setTax(tax.toString());
        salary.setCreatedAt(LocalDateTime.now());
        salary.setGrossSalary(grossSalary.toString());
        salary.setNetSalary(String.valueOf(grossSalary - cas -cass -tax));
        return salary;
    }

    private Long calculateCas(Long grossSalary) {
        return (25 * grossSalary) / 100;
    }

    private Long calculateCass(Long grossSalary) {
        return (10 * grossSalary) / 100;
    }

    private Long calculateTax(Long grossSalary) {
        return (10 * grossSalary) / 100;
    }

}
