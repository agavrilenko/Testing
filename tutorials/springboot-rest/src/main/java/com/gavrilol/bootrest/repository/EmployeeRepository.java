package com.gavrilol.bootrest.repository;

import com.gavrilol.bootrest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
