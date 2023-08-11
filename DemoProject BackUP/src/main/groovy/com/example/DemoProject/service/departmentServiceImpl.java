package com.example.DemoProject.service;

import com.example.DemoProject.Dto.DepartmentDto;
import com.example.DemoProject.Dto.EmployeeDto;
import com.example.DemoProject.Entity.Department;
import com.example.DemoProject.Entity.Employee;
import com.example.DemoProject.exception.ResourceNotFoundException;
import com.example.DemoProject.repo.DepartmentRepo;
import com.example.DemoProject.repo.employeeProjectRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class departmentServiceImpl implements departmentService {

    @Autowired
    private DepartmentRepo repo;

    @Autowired
    private employeeProjectRepo employerepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DepartmentDto getDepartmentById(int id) {
        Department department = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "ID", id));
        return mapper.map(department,DepartmentDto.class);
    }

    @Override
    public DepartmentDto addDepartment(DepartmentDto department) {
        Department department1= mapper.map(department,Department.class);
        Department save= repo.save(department1);
        return mapper.map(save,DepartmentDto.class);
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto department,int id) {
        Department department1= mapper.map(department,Department.class);
        Department getdepartment= repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "ID", id));
        getdepartment.setDepartmentName(department1.getDepartmentName());
        Department save = repo.save(getdepartment);
        return mapper.map(save,DepartmentDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployeeByDepartment(Integer id) {
        Department department = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "ID", id));
        List<Employee> byDepart = employerepo.findByDepart(department);
        List<EmployeeDto> collect = byDepart.stream().map((employee) -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
       return collect;
    }

    @Override
    public void deleteDepartment(int id) {
        Department department = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "ID", id));
        repo.delete(department);
    }
}
