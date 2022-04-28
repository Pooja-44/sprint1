package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.entity.bookingmodel;
import com.example.repository.bookingRepository;
import com.speedment.jpastreamer.application.JPAStreamer;

import java.util.*;
import java.util.stream.Stream;

@Service
public class bookingService {


	private final JPAStreamer jpaStreamer;
	
	
	@Autowired
	public bookingService(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }
	@Autowired
	bookingRepository bookingrepository;
	
	
	
	public List<bookingmodel> getAllbookings()
	{
		
//		return  bookingrepository.findAll();
	return jpaStreamer.stream(bookingmodel.class).toList();
//	 return jpaStreamer.stream(bookingmodel.class).filter(e->e.getGroundName().endsWith("i"));
		
	}
	

	List<bookingmodel> booki=new ArrayList<>();
	public String addbooking(bookingmodel bm) 
	{
		// TODO Auto-generated method stub
	 bookingrepository.save(bm);
	 
	 return "Confirmed";
	
	}
	
			
		

	public bookingmodel updatebooking(bookingmodel bookupdate)
	{
		bookingmodel booking=bookingrepository.findById(bookupdate.getId()).get();
		
//		if(bookupdate.getGroundName()!=null && bookupdate.getGroundName().isEmpty())
//		{
		booking.setGroundName(bookupdate.getGroundName());
		booking.setAddress(bookupdate.getAddress());
		booking.setNoOfPersons(bookupdate.getNoOfPersons());
		booking.setFromDate(bookupdate.getFromDate());
		booking.setToDate(bookupdate.getToDate());
		booking.setTotalPrice(bookupdate.getTotalPrice());
		
		
//		}
	booking=bookingrepository.save(booking);
			return booking;
	}
	
	public  String deletebooking(Long id)
	{
		bookingrepository.deleteById(id);
		return "Booking Deeleted successfully";
	}
	
	



	public Optional<bookingmodel> getbookingById(long id)
	 {
		 
		
//	 Optional<bookingmodel> book = bookingrepository.findById(id).stream().findFirst();
//	 return  book;
		 
	 return jpaStreamer.stream(bookingmodel.class).filter(e->e.getId()==id).findAny();
      
	    }

	
	
}
