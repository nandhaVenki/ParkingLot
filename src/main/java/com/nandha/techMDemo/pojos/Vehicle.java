package com.nandha.techMDemo.pojos;

import java.util.Objects;

public class Vehicle {

	private String number;
	private String type;
	private String company;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, number, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(company, other.company) && Objects.equals(number, other.number)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Vehicle [number=" + number + ", type=" + type + ", company=" + company + "]";
	}
	
}
