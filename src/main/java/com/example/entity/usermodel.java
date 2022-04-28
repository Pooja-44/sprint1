package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

@Table(name="users")
public class usermodel 
{
	

	public usermodel(usermodel um)
	{
		// TODO Auto-generated constructor stub
	}
	@Id
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
//	@GeneratedValue
	
	@Column(name="id")
	
	private long id;
	
	@Column(name="Email" ,unique=true)
	@NotBlank(message = "Email id required")
	private String email;
	
	@NotBlank(message = " password required")
	@Column(name="Password")
	private String  password;
	
	@NotBlank(message = " Confirm password required")
	@Column(name="confirmPassword")
	private String  confirmpassword;
	
	@NotBlank(message = " username required")
	@Column(name="UserName")
	private String  username;
	
	
	@NotBlank(message = " Mobile number  required")
	@Column(name="MobileNo",unique=true)
	private String  mobileNumber;
	
	
	@NotBlank(message = "UserRole")
	@Column(name="UserRole")
	private String  userRole;
	
	@OneToMany(mappedBy="user")
	private List<bookingmodel> bookingmodel;
	
	
	


	
	
	
}
