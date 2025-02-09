class A {
	void play() {
		System.out.println("Parent class");
	}
}

class B extends A {
	void play() {
		System.out.println("Child class");
	}
}
public class SingleInherit {

	public static void main(String[] args) {
		B obj = new B();
		obj.play();
	}

}
