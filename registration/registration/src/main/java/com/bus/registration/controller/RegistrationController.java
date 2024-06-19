package com.bus.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.bus.registration.model.Registration;
import com.bus.registration.service.RegistrationService;

import jakarta.validation.Valid;
//It used for making restful web services with the help of@RestController(Get,post,Delete put)
@RestController
//which is used to map the HTTP Requests to handler method of mvc and rest controller.
@RequestMapping("/register")
public class RegistrationController {
	//used to automatically inject dependencies into beans managed by the Spring container.
	//injects internally
	@Autowired
	private RegistrationService registrationService;
	

	@PostMapping("/addUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody Registration user) throws Exception {
		if(user.getRole().equals("Admin")||user.getRole().equals("User")) {
			return ResponseEntity.ok(registrationService.save(user));
		}
		else
		{
			return new ResponseEntity<>("Please Select a valid role",
                    HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

}