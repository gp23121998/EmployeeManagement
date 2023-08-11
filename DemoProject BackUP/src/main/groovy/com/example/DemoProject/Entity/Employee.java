package com.example.DemoProject.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EmployeeTable")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Employee_ID")
    private int employeeId;
    @Column(name="Employee_Name")
    private String employeeName;

    @ManyToOne
    @JoinColumn(name="department_fk")
    private Department depart;

//    @ManyToMany
//    @JoinTable(name = "Employee-project",joinColumns = @JoinColumn(name = "Employee-list"),inverseJoinColumns=@JoinColumn
//            (name = "Project-list"))
//    private Project projectList[];

}
