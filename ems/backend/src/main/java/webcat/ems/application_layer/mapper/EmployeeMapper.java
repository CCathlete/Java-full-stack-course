package webcat.ems.application_layer.mapper;

import webcat.ems.domain_layer.entities.Employee;
import webcat.ems.application_layer.dto.EmployeeDto;

public class EmployeeMapper {

  /**
   * Maps an {@link Employee} to an {@link EmployeeDto}.
   *
   * @param employee
   *          The employee to map.
   * @return An {@link EmployeeDto} containing the employee's id,
   *         first name, last name, and email.
   */
  public static EmployeeDto mapToEmployeeDto(Employee employee) {
    return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail());
  }


  /**
   * Maps an {@link EmployeeDto} to an {@link Employee}.
   *
   * @param employeeDto
   *          The employee dto to map.
   * @return An {@link Employee} containing the employee's id, first
   *         name, last name, and email.
   */
  public static Employee mapToEmployee(EmployeeDto employeeDto) {
    return new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail());
  }

}
