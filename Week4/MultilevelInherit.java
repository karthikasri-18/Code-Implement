class Grandfather {
	void inherit() {
		System.out.println("Parent class");
	}
}

class Father extends Grandfather{
	void inherit() {
		System.out.println("Sub-Parent class");
	}
}

class Son extends Father {
	void inherit() {
		System.out.println("Child class");
	}
}

public class MultilevelInherit {

	public static void main(String[] args) {
		Father s1 = new Father();
		s1.inherit();
		Son s2 = new Son();
		s2.inherit();
	}

}
