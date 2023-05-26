package com.nandha.techMDemo.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class Parking {
	
	private List<String> levels;
	private List<Integer> slots;
	private Map<Slot, Boolean> parkingLot;
	private Map<Slot, Vehicle> allocated;
	
	private Integer noOfSlots = 5;
	
	public Parking(){
		allocated = new TreeMap<Slot,Vehicle>();
		List<String> levels = new ArrayList<String>();
		levels.add("L1");
		levels.add("L2");
		levels.add("L3");
		levels.add("G");
		levels.add("B1");
		levels.add("B2");
		this.levels = levels;
		List<Integer> slots = new ArrayList<Integer>();
		for(int i=1; i<=noOfSlots;i++){
			slots.add(i);
		}
		this.slots = slots;
		Slot slot = null;
		String vehicletype = "";
		String company = "";
		
		String[] arCompanies = new String[]{"cts","ust","radisys","techM"};
		List<String> companyLi = Arrays.asList(arCompanies);
		
		String[] vehicleTypes = new String[] {"car","bike"};
		List<String> vehicleTypeLi = Arrays.asList(vehicleTypes);
		
		parkingLot = new HashMap<Slot, Boolean>();
		for(String levelNm: levels) {
			company = companyLi.get((int) ((Math.random()*(companyLi.size() - 0)) + 0));
			vehicletype = vehicleTypeLi.get((int) ((Math.random()*(vehicleTypeLi.size() - 0)) + 0));
			for(Integer slotNm: slots) {
				slot = new Slot(slotNm,levelNm,vehicletype,company);
				parkingLot.put(slot, false);
				allocated.put(slot, null);
			}
		}
		
		TreeMap<Slot, Boolean> mp1 = new TreeMap<Slot, Boolean>(parkingLot);
				
		for(Map.Entry<Slot, Boolean> mp : mp1.entrySet()) {
			System.out.println("Slot" + mp.getKey().toString() + " Vacancy: " + mp.getValue());
		}
		
		parkingLot = mp1;
	//	allocated = new TreeMap<Slot,Vehicle>(allocated);
	}
	
	
	public Slot getSlotToPark(String vehicleType, String Company) {
		return parkingLot.entrySet().stream()
							 .filter(en -> en.getValue() == false)
							 .filter(en -> en.getKey().getCompany().equals(Company))
							 .filter(en -> en.getKey().getTypeV().equals(vehicleType))
							 .map(en -> en.getKey())
							 .findFirst()
							 .orElseGet(() -> {return new Slot(0,"","","");});
	}
	
	public Slot getParkedSlot(String vehicleType, String Company) {
		return parkingLot.entrySet().stream()
							 .filter(en -> en.getValue() == true)
							 .filter(en -> en.getKey().getCompany().equals(Company))
							 .filter(en -> en.getKey().getTypeV().equals(vehicleType))
							 .map(en -> en.getKey())
							 .findFirst()
							 .orElseGet(() -> {return new Slot(0,"","","");});
	}

	

	public parkingResponse park(Vehicle ve,Slot slot) {
		parkingResponse ret = new parkingResponse();
		allocated.put(slot, ve);
		Boolean isParked = allocated.get(slot).equals(ve);
		parkingLot.put(slot, isParked);
		ret.setIsParked(isParked);
		ret.setSlot(slot);
		ret.setVehicle(allocated.get(slot));
		return ret;
	}


	public boolean clearSlot(Slot slot) {
		boolean isCleared = false;
		parkingLot.put(slot, false);
		allocated.put(slot, null);
		if( parkingLot.get(slot) == false && (allocated.get(slot) == null) ) {
			isCleared = true;
		}
		return isCleared;
	}

}
