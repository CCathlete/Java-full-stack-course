package webcat.ems.application_layer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * Data Transfer Object for
 * </p>
 * <p>
 * {@link webcat.ems.domain_layer.entities.Employee}.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;

}
