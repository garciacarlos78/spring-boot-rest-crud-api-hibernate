package com.cgrdev.springbootrestcrudapihibernate.service;

import com.cgrdev.springbootrestcrudapihibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getOne(int id);

    Employee create(Employee employee);

    Employee update(Employee employee);

    boolean delete(int id);
}
