package com.memb;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memb.model.UserDetails;

@Service
@Transactional
public class UserDetailsService {

	@Autowired
	private UserDetailsRepository repository;
	
	public void saveUserDetails(UserDetails userDetails) {
		userDetails.setCreatedDate(new Date());
		repository.save(userDetails);
	}
	public UserDetails getUserDetails(String email) {
		return repository.findByEmail(email);
	}
	public void updateUserDetails(UserDetails details) {
		UserDetails userDetails = repository.findByEmail(details.getEmail());
		userDetails.setLastItemPurchased(details.getLastItemPurchased());
	}
}
