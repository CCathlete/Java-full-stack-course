package webcat.ems.infrastructure_layer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webcat.ems.domain_layer.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
