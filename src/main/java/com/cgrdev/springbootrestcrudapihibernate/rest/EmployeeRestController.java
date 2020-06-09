package com.cgrdev.springbootrestcrudapihibernate.rest;

import com.cgrdev.springbootrestcrudapihibernate.dao.EmployeeDAO;
import com.cgrdev.springbootrestcrudapihibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // version 1, quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    // expose "/employees/{employeeId}" and return employee with given id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeDAO.findById(employeeId);
    }
}
