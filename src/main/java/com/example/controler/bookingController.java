package com.example.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.bookingmodel;
import com.example.services.bookingService;



@RestController
@RequestMapping("api/bookingmodel/")
public class bookingController {
	
	@Autowired
	bookingService bookingservice;
	
	@GetMapping("getAll")
	public List<bookingmodel>  getAllBooking()
	{
		return  bookingservice.getAllbookings();
	}
	
	List<bookingmodel> booki=new ArrayList<>();


	@PostMapping("addbooking")
	public String addbooking(@Valid @RequestBody bookingmodel bm)
	{
		
		 return bookingservice.addbooking(bm);
		 
	}
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
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
	public bookingmodel updatebooking( @RequestBody bookingmodel updateBook)
	{
		bookingmodel  booking=bookingservice.updatebooking(updateBook);
		return booking;
		
	}
	
	@DeleteMapping("delete")
	public String deleteBooking(@RequestParam long id)
	{
		return bookingservice.deletebooking(id);
		
	}
	
	  @GetMapping("{id}")
	    public Optional<bookingmodel> getbooking(@PathVariable long id) 
	  {
	        return bookingservice.getbookingById(id);
	   
	  }
	
	
}
