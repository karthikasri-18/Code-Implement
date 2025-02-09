class Default {
	int a,b;
	
	public Default() {
		System.out.println("Default constructor is executed");
	}
	
	public Default(int a, int b) {
		this.a=a;
		this.b=b;
		System.out.println("The sum of the two numbers: "+ (this.a+this.b));
		System.out.println("Parameterized constructor is executed");
	}
	
	public Default (Default other) {
		this.a= other.a;
		this.b= other.b;
		System.out.println("Copy constructor is executed");
	}
	
	public Default (String str) {
		System.out.println("Constructor Overloading");
		System.out.println("The given string is "+str);
	}
}

public class Constructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Default obj1 = new Default();
		Default obj2 = new Default(3,23);
		Default obj3 = new Default(obj2);
		System.out.println("Copy Constructor Attributes:");
		System.out.println("a = "+obj3.a+" b = "+obj3.b);
		Default obj4 = new Default("Planatary Motion");
		
	}

}
