package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.usedcardealership.models.Vehicle;

public class GetterTest {

	@Test
	public void test() {
		
		Vehicle car = new Vehicle();
		     
		assertEquals(car.getId(), car.id);
	}
}
