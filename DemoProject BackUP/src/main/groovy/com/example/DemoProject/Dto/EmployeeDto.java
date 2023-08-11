package com.example.DemoProject.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private int employeeId;

    private String employeeName;

    private DepartmentDto depart;

//    @ManyToMany
//    @JoinTable(name = "Employee-project",joinColumns = @JoinColumn(name = "Employee-list"),inverseJoinColumns=@JoinColumn
//            (name = "Project-list"))
//    private Project projectList[];

}
