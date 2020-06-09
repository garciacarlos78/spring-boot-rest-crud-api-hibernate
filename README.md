# Spring Boot REST CRUD API Hibernate

Simple exercise to manage Employees in a MySQL database via REST API, using Hibernate.

## Commit: Get all employees implemented
Created structure and first endpoint, GET */api/employees*, that returns JSON with all the employees of the database.

## Commit: Get employee by id implemented
Implemented endpoint:
  - GET */api/employees/{employeeId}* : returns employee with given id

## Commit: Create new employee implemented
Implemented endpoint:
  - POST */api/employees* : creates an employee defined in JSON body

## Commit: Update employee implemented
Implemented endpoint:
  - PUT */api/employees* : updates employee defined in JSON body

## Commit: Delete employee implemented
Implemented endpoint:
  - DELETE */api/employees/{employeeId}* : deletes employee with given id

Added POSTMAN collection to test the endpoint (folder /POSTMAN).
  