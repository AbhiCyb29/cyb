package com.cybage.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cybage.payload.request.LoginRequest;
import com.cybage.payload.request.SignupRequest;

@Controller
@RequestMapping("/Api")
public class RestTemplateProvider {
	RestTemplate rest = new RestTemplate();

	// Method
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		return rest.postForObject("localhost:8686/api/auth/signin", loginRequest, ResponseEntity.class, "");
	}

	// Method
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    {
        return rest.postForEntity(
            "localhost:8686/api/auth/signup", signUpRequest,
            ResponseEntity.class, "");
    }

}
}