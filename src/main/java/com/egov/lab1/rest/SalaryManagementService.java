package com.egov.lab1.rest;

import com.egov.lab1.domain.Salary;
import com.egov.lab1.domain.SalaryRepository;
import com.egov.lab1.rest.dto.SalaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryManagementService {

    @Autowired
    private SalaryRepository salaryRepository;

    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }
}
