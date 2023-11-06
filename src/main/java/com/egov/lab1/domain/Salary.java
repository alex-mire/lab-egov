package com.egov.lab1.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String grossSalary;
    private String netSalary;
    private String cas;
    private String cass;
    private String tax;

    private LocalDateTime createdAt;
}
