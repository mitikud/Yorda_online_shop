package com.bezkoder.spring.jwt.mongodb.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	private String token;
//	private String type = "Bearer";
	private String id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private List<String> roles;

}
