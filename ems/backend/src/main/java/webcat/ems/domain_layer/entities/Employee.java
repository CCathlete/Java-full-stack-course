package webcat.ems.domain_layer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an employee in the company.
 * <p>
 * Fields:
 * <ul>
 * <li>(Long) id</li>
 * <li>(String) firstName</li>
 * <li>(String) lastName</li>
 * <li>(String) email</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email_id", nullable = false, unique = true)
  private String email;

}
