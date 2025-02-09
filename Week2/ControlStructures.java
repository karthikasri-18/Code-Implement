public class ControlStructures {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("if..else Statement");
		int age = 21;
		System.out.println("The given age is 21");
		if (age >= 18)
			System.out.println("You are eligible to vote");
		else
			System.out.println("You are not eligible to vote");
		System.out.println("if..else if..else Statement");
		int a = -15;
		System.out.println("The given number is -15");
		if (a > 0)
			System.out.println("The given number is positive.");
		else if (a < 0)
			System.out.println("The given number is negative.");
		else
			System.out.println("The given number is neither positivr nor negative.");
		System.out.println("Switch case Statement");
		int d = 5;
		System.out.println("The given number is 5");
		switch (d) {
		case 1:
			System.out.println("Today is Sunday");
			break;
		case 2:
			System.out.println("Today is Monday");
			break;
		case 3:
			System.out.println("Today is Tuesday");
			break;
		case 4:
			System.out.println("Today is Wednesday");
			break;
		case 5:
			System.out.println("Today is Thursday");
			break;
		case 6:
			System.out.println("Today is Friday");
			break;
		case 7:
			System.out.println("Today is Sunday");
			break;
		}
		System.out.println("for loop");
		System.out.println("Sum of n numbers");
		int n=15;
		int s=0;
		System.out.println("The value of n = 15");
		for(int i=1;i<=n;i++) {
			s+=i;
		}
		System.out.println("The sum of 'n' numbers = "+ s);
		System.out.println("while loop");
		int i=0;
		while (i < n) {
			System.out.print(i+" ");
			i++;
		}
		System.out.println();
		System.out.println("do..while loop");
		int j=0;
		do {
			System.out.print(i+" ");
		} while(j>n);
	}
}
