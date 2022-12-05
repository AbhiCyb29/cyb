//package com.cybage.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.cybage.model.User;
//import com.cybage.payload.request.SignupRequest;
//
//@Controller
//@RequestMapping("/api")
//public class ClientController {
//
//	 @PostMapping 
//	 public ResponseEntity<?> authenticateUser(Model model)
//	    {
//	 
//	        // Creating an instance of RestTemplateProvider class
//	        
//	        RestTemplateProvider restTemplate
//	            = new RestTemplateProvider();
//	 
//	        model.addAttribute("user",
//	                           restTemplate.authenticateUser(null));
//	        model.addAttribute("user", new User());
//	        return ResponseEntity.ok(null);
//	    }
//	 
//	    
//	    @PostMapping
//	    public ResponseEntity<?> registerUser(@ModelAttribute("model")
//	    SignupRequest signUpRequest, Model model)
//	    {
//	 
//	        RestTemplateProvider restTemplate = new RestTemplateProvider();
//	 
//	        ResponseEntity<?> response = restTemplate.registerUser(signUpRequest);
//	 
//	        model.addAttribute("user", response.getBody());
//	        model.addAttribute("headers",
//	                           response.getHeaders() + " "
//	                               + response.getStatusCode());
//	        return ResponseEntity.ok(null);
//	    }
//	}
//
