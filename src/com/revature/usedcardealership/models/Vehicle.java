package com.revature.usedcardealership.models;

public class Vehicle {

	private String make;
	private String model;
	private int year;
	private boolean forSale;
	
	public Vehicle() {
		
	}

	public Vehicle(String make, String model) {
		super();
		this.make = make;
		this.model = model;
	}
	
	public Vehicle(String make, String model, int year, boolean forSale) {
		this(make, model);
		this.year = year;
		this.forSale = forSale;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}
	
	@Override
	public String toString() {
		return "[make=" + make + ", model=" + model + ", year=" + year + ", forSale=" + forSale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (forSale ? 1231 : 1237);
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
		return result;
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
		if (forSale != other.forSale)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
}
