package com.example.DemoProject.service;


import com.example.DemoProject.Dto.EmployeeDto;
import com.example.DemoProject.Entity.Employee;

public interface employeeService {

    //getEmployeeById (get)
    public EmployeeDto getEmployeeById(int id);

    //addEmployee (post)
    public EmployeeDto addEmployee(EmployeeDto employee,int departmentid);

    //updateEmployee (put)
    public EmployeeDto updateEmployee(EmployeeDto employee, int id);

    //deleteEmployee(delete)
    public void deleteEmployee(int id);

}
