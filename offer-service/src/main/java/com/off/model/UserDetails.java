package com.off.model;

import java.util.Date;




public class UserDetails {
	
	
	private Long id;
	private String email;
	private Date createdDate;
	private String lastItemPurchased;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastItemPurchased() {
		return lastItemPurchased;
	}
	public void setLastItemPurchased(String lastItemPurchased) {
		this.lastItemPurchased = lastItemPurchased;
	}
	
	
}
