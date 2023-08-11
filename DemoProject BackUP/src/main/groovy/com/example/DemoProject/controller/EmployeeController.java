package com.example.DemoProject.controller;


import com.example.DemoProject.Dto.EmployeeDto;
import com.example.DemoProject.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.DemoProject.service.employeeServiceImp;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private employeeServiceImp service;

    //post
    @PostMapping("/dep/{departmentid}")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee, @PathVariable int departmentid){
        EmployeeDto employee1 = service.addEmployee(employee,departmentid);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    //get
    @GetMapping("/emp/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id){
        EmployeeDto employeeById = service.getEmployeeById(id);
        return new ResponseEntity<>(employeeById, HttpStatus.FOUND);
    }

    //update
    @PutMapping("/emp/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @PathVariable int id, @RequestBody EmployeeDto employee){
        EmployeeDto emp = service.updateEmployee(employee,id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deletemployee(@PathVariable int id){
        service.deleteEmployee(id);
        return new ResponseEntity<>(Map.of("message","Employee is deleted"),HttpStatus.OK);
    }


}
