package com.example.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class adminmodel 
{
	

	public adminmodel(adminmodel am)
	{
		// TODO Auto-generated constructor stub
	}
	
	@Id
//	@NotBlank(message = "Email id required")
	private String email;
	
//	@NotBlank(message = " password required")

	private String  password;
	
//	@NotBlank(message = " Confirm password required")
	
	private String  confirmpassword;
	
//    @NotBlank(message = " username required")

	private String  username;
	
//	@NotBlank(message = " Mobile number  required")
    
	private String  mobileNumber;
	
	
//	@NotBlank(message = "UserRole")
	
	private String  userRole;
	
	
}
	
	