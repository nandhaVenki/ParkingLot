package com.nandha.techMDemo.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class parkingResponse {
	private Boolean isParked;
	private Slot slot;
	private Vehicle vehicle;
	private String message;
	private String leaveParking;
	
	
	public parkingResponse() {
		
	}
	
	public parkingResponse(Boolean isParked, Slot slot, Vehicle vehicle) {
		this.isParked = isParked;
		this.slot = slot;
		this.vehicle = vehicle;
	}
	public parkingResponse(Boolean isParked, Slot slot, Vehicle vehicle,String error) {
		this.isParked = isParked;
		this.slot = slot;
		this.vehicle = vehicle;
		this.message = error;
	}
	
	public Boolean getIsParked() {
		return isParked;
	}
	public void setIsParked(Boolean isParked) {
		this.isParked = isParked;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLeaveParking() {
		return leaveParking;
	}

	public void setLeaveParking(String leaveParking) {
		this.leaveParking = leaveParking;
	} 
	
}
