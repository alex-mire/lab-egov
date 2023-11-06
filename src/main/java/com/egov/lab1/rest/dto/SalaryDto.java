package com.egov.lab1.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SalaryDto {
    @NotNull(message = "Trebuie sa introduci salariul!")
    private String salary;
}
