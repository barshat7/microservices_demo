package com.memb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memb.model.UserDetails;

@RestController
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUserDetails(@RequestBody UserDetails details) {
		service.saveUserDetails(details);
		return new ResponseEntity<>("Membership Created",HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateUserDetails(@RequestBody UserDetails details){
		service.updateUserDetails(details);
		return new ResponseEntity<>("Updated",HttpStatus.OK);
	}
	@GetMapping("/user")
	public UserDetails getUserDetails(@RequestParam("email") String email) {
		
		UserDetails details = service.getUserDetails(email);
		return details;
	}
	
}
