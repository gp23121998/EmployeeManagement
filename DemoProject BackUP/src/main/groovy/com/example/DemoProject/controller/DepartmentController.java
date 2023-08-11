package com.example.DemoProject.controller;

import com.example.DemoProject.Dto.DepartmentDto;
import com.example.DemoProject.Dto.EmployeeDto;
import com.example.DemoProject.Entity.Department;
import com.example.DemoProject.Entity.Employee;
import com.example.DemoProject.service.departmentService;
import com.example.DemoProject.service.departmentServiceImpl;
import com.example.DemoProject.service.employeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private departmentServiceImpl service;

    //post
    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto department){
        DepartmentDto department1 = service.addDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    //get
    @GetMapping("/dep/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable int id){
        DepartmentDto departmentById = service.getDepartmentById(id);
        return new ResponseEntity<>(departmentById, HttpStatus.FOUND);
    }

    //update
    @PutMapping("/dep/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@Valid @PathVariable int id, @RequestBody DepartmentDto department){
       DepartmentDto department1 = service.updateDepartment(department,id);
        return new ResponseEntity<>(department1, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/dep/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable int id){
        service.deleteDepartment(id);
        return new ResponseEntity<>(Map.of("message","Employee is deleted"),HttpStatus.OK);
    }

    @GetMapping("/allemployee/{departmentid}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeByDepartment(@PathVariable int departmentid){
        List<EmployeeDto> allEmployeeByDepartment = service.getAllEmployeeByDepartment(departmentid);
        return new ResponseEntity<>(allEmployeeByDepartment, HttpStatus.FOUND);
    }


}
