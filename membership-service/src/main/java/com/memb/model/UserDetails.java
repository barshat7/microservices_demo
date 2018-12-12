package com.memb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserDetails {
	
	@Id @GeneratedValue
	private Long id;
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
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
