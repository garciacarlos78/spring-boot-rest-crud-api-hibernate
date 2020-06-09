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
}





























