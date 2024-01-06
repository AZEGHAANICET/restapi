package com.example.lovecodeakalo.rest;

import com.example.lovecodeakalo.dao.EmployeeDAO;
import com.example.lovecodeakalo.dao.EmployeeDAOJpaImpl;
import com.example.lovecodeakalo.entity.Employee;
import com.example.lovecodeakalo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    // quick and dirty: inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
       this.employeeService = theEmployeeService;

    }




    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }
}
