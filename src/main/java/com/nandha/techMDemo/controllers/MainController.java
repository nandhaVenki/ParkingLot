package com.nandha.techMDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nandha.techMDemo.pojos.Response;
import com.nandha.techMDemo.pojos.Vehicle;
import com.nandha.techMDemo.pojos.parkingResponse;
import com.nandha.techMDemo.service.PageDetailsService;
import com.nandha.techMDemo.service.ParkingService;

@RestController
public class MainController {
	
	@Autowired 
	PageDetailsService pageDetailsService;
	
	@Autowired
	ParkingService parkingService;
	
	@RequestMapping(method = RequestMethod.GET, value = "datastager/ads/monitor/v1/ping")
	public Response method01() {
		return pageDetailsService.getDetails();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/park" )
	public parkingResponse parkVehichle(@RequestBody Vehicle vehicle) {
		return parkingService.park(vehicle);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/leave" )
	public parkingResponse leaveVehichle(@RequestBody Vehicle vehicle) {
		return parkingService.leave(vehicle);
	}
	
	// park vehicle
	// leave vehicle
	
	
	// park vehicle
	// exit vehichle
	// companywise parking lot
	// types car n bike
	
	// vehicle comes checks for availablilty
	// gets the available slot and parks
	// if no availabilty - then leaves
	// after some time leaves the parking and empties the slot
	// slots will be occupied pased on prioroity levels and slots
	

}
