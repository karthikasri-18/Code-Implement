class MainMethod {
	public void Sum(int a, int b) {
		System.out.println("Sum of Two numbers = "+(a+b));
	}
	
	public void Sum(int a, int b, int c) {
		System.out.println("Sum of Three numbers = "+(a+b+c));
	}
	
	public void Sum(String a, String b) {
		System.out.println("Concatination of two strings = "+(a+b));
	}
}

public class Polymorph {

	public static void main(String[] args) {
		MainMethod obj = new MainMethod();
		obj.Sum(3,4,8);
		obj.Sum("Red","Apples");
		obj.Sum(8, 12);
	}
}
