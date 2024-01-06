package com.example.lovecodeakalo.rest;

import com.example.lovecodeakalo.dao.EmployeeDAO;
import com.example.lovecodeakalo.dao.EmployeeDAOJpaImpl;
import com.example.lovecodeakalo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;
    // quick and dirty: inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;

    }




    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}