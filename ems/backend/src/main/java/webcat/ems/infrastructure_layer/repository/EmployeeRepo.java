package webcat.ems.infrastructure_layer.repository;

import webcat.ems.domain_layer.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
