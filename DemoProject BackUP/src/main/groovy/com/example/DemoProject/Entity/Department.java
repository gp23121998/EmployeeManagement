package com.example.DemoProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    private int departmentId;
    private String departmentName;
    @OneToMany(mappedBy = "depart",cascade = CascadeType.ALL)
    private List<Employee> employeeList=new ArrayList<>();
}
