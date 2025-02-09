class Vehicle {
	void wheels() {
		System.out.println("All vehicles have wheels");
	}
}

class Car extends Vehicle {
	void wheels() {
		System.out.println("Cars have four wheels");
	}
}

class Bike extends Vehicle {
	void wheels() {
		System.out.println("Bike have two wheels");
	}
}
public class HierarchyInherit {

	public static void main(String[] args) {
		Vehicle t1 = new Vehicle();
		t1.wheels();
		Bike t2 = new Bike();
		t2.wheels();
		Car t3 = new Car();
		t3.wheels();
	}

}
