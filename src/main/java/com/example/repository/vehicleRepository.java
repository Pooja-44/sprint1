package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entity.vehiclemodel;

public interface vehicleRepository extends JpaRepository<vehiclemodel,Long>
{

}
