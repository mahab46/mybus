package com.bus.booking_service.ExternalClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@Data
//It is used to generate a constructor with one parameter for every field in the class
@AllArgsConstructor
//It is Default constructor.generate a constructor with no parameters
@NoArgsConstructor
public class LoginModel {

	private String username;
	private String password;
	private String role;
	private String email;
	private String gender;
	private Integer age;
	private String country;

}