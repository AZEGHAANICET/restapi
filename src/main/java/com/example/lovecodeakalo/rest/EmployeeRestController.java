package com.example.lovecodeakalo.rest;

import com.example.lovecodeakalo.entity.Employee;
import com.example.lovecodeakalo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
       Employee employee = employeeService.findById(employeeId);
        if( employee==null){
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        return employee;

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee tempEmployee = employeeService.findById(id);

        if(tempEmployee==null) throw new RuntimeException("Employe id "+id+"does not exist please try again!!!!!");
        employeeService.deleteById(id);
        return "delete employee "+tempEmployee.getFirstName()+" with success";
    }

}
