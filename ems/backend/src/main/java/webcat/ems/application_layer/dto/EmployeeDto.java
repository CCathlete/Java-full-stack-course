package webcat.ems.application_layer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * @param private
 *          Long id;
 * @param private
 *          String firstName;
 * @param private
 *          String lastName;
 * @param private
 *          String email;
 */
public class EmployeeDto {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;

}
