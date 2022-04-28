package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.usermodel;

@Repository
public interface userRepository extends JpaRepository<usermodel,Long>
{

	public usermodel findByEmailAndPasswordAndUserRole(String email, String password, String userRole) ;
		
		
	

}
