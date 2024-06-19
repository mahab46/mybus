package com.bus.booking_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.booking_service.ExternalClasses.BusBookingVo;
import com.bus.booking_service.model.BookingModel;
import com.bus.booking_service.service.BookingService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;



//it is used to automatically generate a logger field in the class where it is applied.
// it eliminates the need to manually create a logger instance.
@Slf4j
//It used for making restful web services with the help of@RestController(Get,post,Delete put)
@RestController
//which is used to map the HTTP Requests to handler method of mvc and rest controller.
@RequestMapping("/bookings")
public class BookingController {
	//injects internally
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/booking")
	//it indicates that the object should be validated according to the validation constraints defined on its fields
	//you will get your values mapped with the model you created in your System for handling and specific call.
	//giving the request for client to server

	public BookingModel bookTicket(@Valid @RequestBody BookingModel booking) {
		
		return bookingService.bookTicket(booking);
	}
	
	 @DeleteMapping("/deleteTicket/{ticketNo}")
	 //it is used to exract the value of the template variables and assign their value to a method variable.
	    public String cancelTicket(@PathVariable String ticketNo) {
		
		 return bookingService.cancelTicket(ticketNo);
	 }
	 
	 @GetMapping("/ViewAllBookings")
	    public List<BookingModel> viewAllBookings() {
		 log.info("Retrieving AllBookings Data ");
		 return bookingService.getAllBookings();
	 }
	 
	 @GetMapping("/ViewTicketByTicketNo/{ticketNo}") 
	    public BookingModel viewByticketNo(@PathVariable String ticketNo) {
		 log.info("Retrieving Tickets Data by ticketNo ");
		 return bookingService.getBookingByticketNo(ticketNo);
	 }
	 
	 @GetMapping("/viewByUserName/{username}")
	    public List<BookingModel> viewByUserName(@PathVariable String username) {
	        log.info("viewByUserName Method Started Inside the Authorize Controller");
	        List<BookingModel> bookings = bookingService.getBookingByUsername(username);
	        return bookings;
	    }
	 @GetMapping("/ViewBookingTicketByItsBusAndTotalCost/{ticketNo}")
	 public BusBookingVo getBookingTicketByItsBusAndTotalCost(@PathVariable String ticketNo) {
		 return bookingService.getTicketDetailsWithBusDetails(ticketNo);
	 }

}
