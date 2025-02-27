package com.bus.customerissue.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bus.customerissue.model.LoginModel;


@FeignClient(name = "LOGINSERVICE",url="http://localhost:9005")
public interface LoginProxy {
	
	@GetMapping("/registration/authorization/getbyUsername/{username}")
	public LoginModel getbyUserName(@PathVariable String username);

}
