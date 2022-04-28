package com.example.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.yaml.snakeyaml.tokens.Token.ID;

import com.example.entity.bookingmodel;

@Repository
public interface bookingRepository extends JpaRepository<bookingmodel ,Long>
{

	
	

}
