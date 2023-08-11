package com.example.DemoProject.service;


import com.example.DemoProject.Dto.EmployeeDto;
import com.example.DemoProject.Entity.Department;
import com.example.DemoProject.Entity.Employee;
import com.example.DemoProject.exception.ResourceNotFoundException;
import com.example.DemoProject.repo.DepartmentRepo;
import com.example.DemoProject.repo.employeeProjectRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class employeeServiceImp implements employeeService{

    @Autowired
    private employeeProjectRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public EmployeeDto getEmployeeById(int id) {

        Employee employee = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));

        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employee,int departmentid) {
        Department department = departmentRepo.findById(departmentid).orElseThrow(() -> new ResourceNotFoundException("department", "ID", departmentid));
        System.out.println(department);
        Employee employee1= mapper.map(employee,Employee.class);
        System.out.println(employee1);
        employee1.setDepart(department);
         Employee save = repo.save(employee1);
         return mapper.map(save, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee, int id) {
        Employee employee1 = mapper.map(employee,Employee.class);
        Employee emp = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        emp.setEmployeeName(employee1.getEmployeeName());
        emp.setDepart(employee1.getDepart());
        Employee save = repo.save(emp);
        return mapper.map(save, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        repo.delete(employee);
    }
}
