package webcat.ems.application_layer.exceptions;

import webcat.ems.application_layer.dto.EmployeeDto;
import webcat.ems.domain_layer.model.entities.Employee;

public class EmployeeMapper {

  /**
   * Maps an {@link Employee} to an {@link EmployeeDto}.
   *
   * @param employee
   *          The employee to map.
   * @return An {@link EmployeeDto} containing the employee's id, first name, last
   *         name, and email.
   */
  public static EmployeeDto mapToEmployeeDto(Employee employee) {
    return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail());
  }

}
