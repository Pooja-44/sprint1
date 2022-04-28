package com.example.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.vehiclemodel;
import com.example.services.vehicleService;



	
	@RestController
	@RequestMapping("/api/vehiclemodel/")
	public class vehicleController  {
		
		@Autowired
		vehicleService vehicleservice;
		
		@GetMapping("getAll")
		public List<vehiclemodel>  getAllvehicles()
		{
			return  vehicleservice.getAllvehicles();
		}
		
		
		@PostMapping("addvehicle")
		public vehiclemodel addbooking(@Valid @RequestBody vehiclemodel vm)
		{
			 return vehicleservice.addvehicle(vm);
		}
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String> handleValidationExceptions(
		  MethodArgumentNotValidException ex) {
		    Map<String, String> errors = new HashMap<>();
		    ex.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
		    return errors;
		}
		
		@PutMapping("update")
		public vehiclemodel updatebooking( @RequestBody vehiclemodel updatevehicle)
		{
			vehiclemodel  vehicle=vehicleservice.updatevehicle(updatevehicle);
			return vehicle;
			
		}
		
		@DeleteMapping("delete")
		public String deletevehicle(@RequestParam long id)
		{
			return vehicleservice.deletevehicle(id);
			
		}
		

	
}
