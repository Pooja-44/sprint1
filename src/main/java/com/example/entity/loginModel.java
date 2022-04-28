package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class loginModel
{
	
	
   public loginModel(loginModel lm)
	{
	 
		// TODO Auto-generated constructor stub
	}
	@Id
	private long id;

//	@NotBlank(message = "Email id required")
	private String email;
	
//	@NotBlank(message = " password required")
    private String  password;
	
	

}
