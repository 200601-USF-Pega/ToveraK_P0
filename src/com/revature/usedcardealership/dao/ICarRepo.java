package com.revature.usedcardealership.dao;

import com.revature.usedcardealership.models.Vehicle;
import java.util.List;

public interface ICarRepo {
	Vehicle addVehicle(Vehicle vehicle);

	void getAllCars();
	
	//public List<Vehicle> getAllCars();


}
