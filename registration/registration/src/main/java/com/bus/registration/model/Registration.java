package com.bus.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@Data
//It is used to generate a constructor with one parameter for every field in the class
@AllArgsConstructor
//It is Default constructor.generate a constructor with no parameters
@NoArgsConstructor
//It provides an abstraction layer over MongoDB, making it easier to interact with the database in a Spring application. 
@Document(collection="bususerlogin")
public class Registration {
//
	//it indicating the member field below is the primary key of the current entity.
	@Id
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,20}$",message="Username should contain alphabets and numbers and Length should be between 3 and 20 characters")
	private String username;
	
	@Size(min=8,message="Password length should be atleast 8 characters")
	private String password;

	@Pattern(regexp="^(User|Admin)$",message="Role must be either User or Admin")
	private String role;
	
	@Email(message="Invalid email address format")
	private String email;
	
	@Pattern(regexp="^(Male|Female)$",message="Gender must be either Male or Female")
	private String gender;
	
	@Min(value = 0, message ="Age cannot be less than zero")
    @Max(value = 100, message = "Age cannot be greater than 100")
    private int age;
    
    @NotBlank(message = "Country cannot be empty")
    private String country;
}

