package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.usedcardealership.models.Vehicle;

public class GetYear {

	@Test
	public void test() {
		Vehicle car = new Vehicle();
		
		assertEquals(car.getYear(), car.year);
	}

}
