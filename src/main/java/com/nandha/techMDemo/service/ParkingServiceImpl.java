package com.nandha.techMDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nandha.techMDemo.pojos.Parking;
import com.nandha.techMDemo.pojos.Slot;
import com.nandha.techMDemo.pojos.Vehicle;
import com.nandha.techMDemo.pojos.parkingResponse;

@Component
public class ParkingServiceImpl implements ParkingService{

	@Autowired
	Parking parkingRepo;
	
	@Override
	public parkingResponse park(Vehicle ve) {
		Slot slot = parkingRepo.getSlotToPark(ve.getType(), ve.getCompany());
		if(slot.getSlotNumber() != 0) {
			return parkingRepo.park(ve,slot);
		}else {
			return new parkingResponse(false,null,null,"Parking space is Not Available");
		}

	}

	@Override
	public parkingResponse leave(Vehicle ve) {
		Slot slot = parkingRepo.getParkedSlot(ve.getType(), ve.getCompany());
		if(slot.getSlotNumber() != 0) {
			if(parkingRepo.clearSlot(slot)) {
				parkingResponse ret = new parkingResponse(false, null, ve,"Vehicle left the parking");
				ret.setLeaveParking("Success");
				return ret;
			}else {
				return new parkingResponse(false, null, ve,"Parking spacce is not cleared");
			}
			
			
		}else {
			return new parkingResponse(false, null, ve, "Vehicle is not parked");
		}
	}

}
