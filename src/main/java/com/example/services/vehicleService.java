package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.vehiclemodel;
import com.example.repository.vehicleRepository;

@Service

	
public class vehicleService 
{
	@Autowired
	
	vehicleRepository vehiclrepository;
	
//	get all the details
	public List<vehiclemodel> getAllvehicles()
	{
		return  vehiclrepository.findAll();
	}
	
//	Add
	public vehiclemodel addvehicle(vehiclemodel vm) {
		// TODO Auto-generated method stub
	return  vehiclrepository.save(vm);
 
	}
	
	
//	Delete
	public  String deletevehicle(Long id)
	{
		vehiclrepository.deleteById(id);
		return "Vehicle Deeleted successfully";
	}
	
	
//	update
	
	public vehiclemodel updatevehicle(vehiclemodel vehicleupdate)
	{
		vehiclemodel vehicle=vehiclrepository.findById(vehicleupdate.getId()).get();
		
//		if(bookupdate.getGroundName()!=null && bookupdate.getGroundName().isEmpty())
//		{
		vehicle.setVehicleId(vehicleupdate.getVehicleId());
		vehicle.setVehicleName(vehicleupdate.getVehicleName());
		vehicle.setVehicleAdress(vehicleupdate.getVehicleAdress());
		vehicle.setVehicleImageURL(vehicleupdate.getVehicleImageURL());
		vehicle.setVehicleDescription(vehicleupdate.getVehicleDescription());
		vehicle.setVehicleAvailableStatus(vehicleupdate.getVehicleAvailableStatus());
		vehicle.setPrice(vehicleupdate.getPrice());
		
		
		
		
//		}
	vehicle=vehiclrepository.save(vehicle);
			return vehicle;
	}
	
	
}
