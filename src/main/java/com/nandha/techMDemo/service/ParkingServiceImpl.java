package com.nandha.techMDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nandha.techMDemo.pojos.Slot;
import com.nandha.techMDemo.pojos.Vehicle;
import com.nandha.techMDemo.pojos.parkingResponse;
import com.nandha.techMDemo.repos.ParkingRepo;

@Component
public class ParkingServiceImpl implements ParkingService{

	@Autowired
	ParkingRepo parkingRepo;
	
	Logger logger = LoggerFactory.getLogger(ParkingServiceImpl.class);
	
	@Override
	public parkingResponse park(Vehicle ve) {
		try {
			Slot slot = parkingRepo.getSlotToPark(ve.getType(), ve.getCompany());
			if(slot.getSlotNumber() != 0) {
				return parkingRepo.park(ve,slot);
			}else {
				return new parkingResponse(false,null,null,"Parking space is Not Available");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new parkingResponse(false,null,null,"Error occured");
		
	}

	@Override
	public parkingResponse leave(Vehicle ve) {
		try {
		Slot slot = parkingRepo.getParkedSlot(ve.getType(), ve.getCompany());
		if(slot.getSlotNumber() != 0) {
			if(parkingRepo.clearSlot(slot)) {
				parkingResponse ret = new parkingResponse(false, null, ve,"Vehicle left the parking");
				ret.setLeaveParking("Success");
				logger.info("Vehicle " + ve.toString() + "left the parking");
				return ret;
			}else {
				logger.error("Parking spacce is not cleared");
				return new parkingResponse(false, null, ve,"Parking spacce is not cleared");
			}
		}else {
			logger.error("Vehicle is not parked");
			return new parkingResponse(false, null, ve, "Vehicle is not parked");
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return new parkingResponse(false,null,null,"Error occured");
	}

}
