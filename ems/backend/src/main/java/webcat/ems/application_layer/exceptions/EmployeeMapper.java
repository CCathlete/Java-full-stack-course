package webcat.ems.application_layer.exceptions;

import webcat.ems.application_layer.dto.EmployeeDto;
import webcat.ems.domain_layer.model.entities.Employee;

public class EmployeeMapper {

  public static EmployeeDto mapToEmployeeDto(Employee employee) {
    return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail());
  }

}
