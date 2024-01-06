package com.example.lovecodeakalo.service;

import com.example.lovecodeakalo.dao.EmployeeDAO;
import com.example.lovecodeakalo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeDAO employeeDAO;

@Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}