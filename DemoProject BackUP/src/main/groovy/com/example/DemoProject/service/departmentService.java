package com.example.DemoProject.service;

import com.example.DemoProject.Dto.DepartmentDto;
import com.example.DemoProject.Dto.EmployeeDto;
import com.example.DemoProject.Entity.Department;
import com.example.DemoProject.Entity.Employee;

import java.util.List;

public interface departmentService {
    //get
    public DepartmentDto getDepartmentById(int id);

    //add
    public DepartmentDto addDepartment(DepartmentDto department);

    //update
    public DepartmentDto updateDepartment(DepartmentDto department,int id);

    //getallemployeebydepartment

    public List<EmployeeDto> getAllEmployeeByDepartment(Integer id);

    //delete
    public void deleteDepartment(int id);
}
