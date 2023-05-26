package com.nandha.techMDemo.service;

import org.springframework.stereotype.Service;

import com.nandha.techMDemo.pojos.Vehicle;
import com.nandha.techMDemo.pojos.parkingResponse;

@Service
public interface ParkingService {
	
	public parkingResponse park(Vehicle ve);
	
	public parkingResponse leave(Vehicle ve);

}
