public class Operators {

	public static void main(String[] args) {
		int a = 20, b = 10;
		boolean x=true, y=false;
		System.out.println("Arithmetic Operators:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        System.out.println("Assignment Operators:"); 
        System.out.println("a += b: " + (a += b));
        System.out.println("a -= b: " + (a -= b));
        System.out.println("a *= b: " + (a *= b));
        System.out.println("a /= b: " + (a /= b));
        System.out.println("a %= b: " + (a %= b));
        System.out.println("Relational Operators:");
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("Logical Operators:");
        System.out.println("a && b: " + (x && y));
        System.out.println("a || b: " + (x || y)); 	 	
        System.out.println("!a: " + (!x));
        System.out.println("Unary Operators:");
        System.out.println("Postincrement : " + (a++));
        System.out.println("Preincrement : " + (++a));
        System.out.println("Postdecrement : " + (b--));
        System.out.println("Predecrement : " + (--b));
        System.out.println("Bitwise Operators:");
        System.out.println("a & b : " + (a & b));
        System.out.println("a | b : " + (a | b));
        System.out.println("a ^ b : " + (a ^ b));
        System.out.println("~b : " + (~b));
        System.out.println("a << 2 : " + (a << 2));
        System.out.println("b >> 1 : " + (b >> 1));
        System.out.println("a >>> 1 : " + (a >>> 1));
    }
}