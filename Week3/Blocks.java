public class Blocks {
	
	static int a;
	int b;
	
	static
	{
		System.out.println("Static block is executed");
		a = 32;
	}
	
	{
		System.out.println("Instance block is executed");
		b = 12;
	}
	
	public Blocks() {
		System.out.println("a = "+a+" b = "+b);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
        Blocks a1 = new Blocks();
	}

}
