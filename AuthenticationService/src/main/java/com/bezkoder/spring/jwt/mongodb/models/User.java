package com.bezkoder.spring.jwt.mongodb.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
  @Id
  private String id;

  @NotBlank(message = "First name can not be empty")
  @Size(max = 20)
  private String firstName;
  @NotBlank(message = "Last name can not be empty")
  @Size(max = 20)
  private String lastName;

  @NotBlank(message = "username name can not be empty")
  @Size(max = 20)
  private String username;

  @NotBlank(message = "email  can not be empty")
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank(message = "password  can not be empty")
  @Size(max = 120)
  private String password;

  @DBRef
  private Set<Role> roles = new HashSet<>();


  public User(String firstName,String lastName,String username, String email, String password) {
    this.firstName=firstName;
    this.lastName=lastName;
    this.username=username;
    this.email=email;
    this.password=password;
  }
}
