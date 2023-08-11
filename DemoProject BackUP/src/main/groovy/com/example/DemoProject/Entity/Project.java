package com.example.DemoProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    private int projectId;
    private String projectName;

    /*@ManyToMany(mappedBy="projectList")
    private List<Employee>employeeList;*/
}
