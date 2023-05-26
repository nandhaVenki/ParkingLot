package com.nandha.techMDemo.pojos;

public class Slot implements Comparable<Slot> {
	private Integer slotNumber;
	private String level;
	private String typeV;
	private String company;
	
	public Slot(Integer slotNumber, String level) {
		this.slotNumber = slotNumber;
		this.level = level;
	}
	
	public Slot(Integer slotNumber, String level,String typeV, String company) {
		this.slotNumber = slotNumber;
		this.level = level;
		this.typeV = typeV;
		this.company = company;
	}
	
	public Slot() {
		
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTypeV() {
		return typeV;
	}
	public void setTypeV(String typeV) {
		this.typeV = typeV;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Slot [slotNumber=" + slotNumber + ", level=" + level + ", typeV=" + typeV + ", company=" + company
				+ "]";
	}

	@Override
	public int compareTo(Slot o) {
		String s1 = this.getLevel() + this.getSlotNumber();
		String s2 = o.getLevel() + o.getSlotNumber();
		return s1.compareTo(s2);
	}
	
	
}
