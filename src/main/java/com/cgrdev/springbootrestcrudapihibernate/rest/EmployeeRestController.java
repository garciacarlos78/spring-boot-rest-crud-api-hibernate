package com.cgrdev.springbootrestcrudapihibernate.rest;

import com.cgrdev.springbootrestcrudapihibernate.dao.EmployeeDAO;
import com.cgrdev.springbootrestcrudapihibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO Exception handling in general
//  - Correct id (0 < id < MAX_INT)

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

    // creates a new employee using the data received in the JSON body
    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return employeeDAO.create(employee);
    }

    // update existing employee
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeDAO.update(employee);
    }
}
