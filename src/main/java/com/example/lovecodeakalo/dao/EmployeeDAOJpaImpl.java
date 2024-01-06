package com.example.lovecodeakalo.dao;

import com.example.lovecodeakalo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements  EmployeeDAO{

    private EntityManager entityManager;



    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theEmployees =entityManager.createQuery("from Employee", Employee.class);


     List<Employee> employees = theEmployees.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        Employee  dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
Employee employee = entityManager.find(Employee.class, theId);

entityManager.remove(employee);

    }
}
