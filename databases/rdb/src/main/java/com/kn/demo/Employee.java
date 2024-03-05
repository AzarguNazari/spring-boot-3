package com.kn.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "employee")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee{
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String name;
    private String email;
}
