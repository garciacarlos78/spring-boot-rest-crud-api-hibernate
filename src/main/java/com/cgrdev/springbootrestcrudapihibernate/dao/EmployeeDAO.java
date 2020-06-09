package com.cgrdev.springbootrestcrudapihibernate.dao;

import com.cgrdev.springbootrestcrudapihibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee create(Employee employee);

    Employee update(Employee employee);

     void delete(int id);
}
