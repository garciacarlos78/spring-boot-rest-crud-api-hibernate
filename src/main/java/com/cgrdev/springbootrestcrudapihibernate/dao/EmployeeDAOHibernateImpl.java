package com.cgrdev.springbootrestcrudapihibernate.dao;

import com.cgrdev.springbootrestcrudapihibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create query
        Query<Employee> query =
                session.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return results
        return employees;
    }

    @Override
    @Transactional
    public Employee findById(int id) {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create query
        Query<Employee> query =
                session.createQuery("from Employee where id=:employeeId", Employee.class);
        query.setParameter("employeeId", id);

        // execute query and get resulting employee
        // TODO Exception handling (employee not found, invalid id...)
        Employee employee = query.getSingleResult();

        // return result
        return employee;
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {

        // get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        checkId(employee.getId(), session);

        // create received employee
        session.saveOrUpdate(employee);

        // return just created employee (includes actual id)
        return employee;
    }

    @Override
    @Transactional
    public Employee update(Employee newEmployee) {

        // get current session
        Session session = entityManager.unwrap(Session.class);

        // check if exists employee with given id
        Employee dbEmployee = session.find(Employee.class, newEmployee.getId());
        if (dbEmployee==null)
            throw new RuntimeException("Employee with id not found - " + newEmployee.getId());

        // update database employee with new employee's data
        updateEmployee(dbEmployee, newEmployee);

        // return employee
        return dbEmployee;
    }

    private void updateEmployee(Employee dbEmployee, Employee newEmployee) {
        String field = newEmployee.getFirstName();
        if (field!=null) dbEmployee.setFirstName(field);
        field = newEmployee.getLastName();
        if (field!=null) dbEmployee.setLastName(field);
        field = newEmployee.getEmail();
        if (field!=null) dbEmployee.setEmail(field);
    }

    private void checkId(int id, Session session) {
        Employee employee = session.get(Employee.class, id);
        if (employee != null) throw new RuntimeException("Employee id must be 0 or not be.");
    }
}





























