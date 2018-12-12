package com.memb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memb.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	
	public UserDetails findByEmail(String email);
}
