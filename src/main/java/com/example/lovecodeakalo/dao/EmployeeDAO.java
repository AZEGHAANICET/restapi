package com.example.lovecodeakalo.dao;

import com.example.lovecodeakalo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
