package com.example.DemoProject.repo;


import com.example.DemoProject.Entity.Department;
import com.example.DemoProject.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeProjectRepo extends JpaRepository<Employee,Integer> {

    List<Employee> findByDepart(Department department);
}
