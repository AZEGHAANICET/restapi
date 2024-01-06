package com.example.lovecodeakalo.dao;

import com.example.lovecodeakalo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();


    Employee findById(int theId);
    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
