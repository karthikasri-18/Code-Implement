class Bank {
	private int acc_num;
	private String acc_name;
	private double acc_bal;
	
	Bank(int num, String name, double bal){
		acc_num = num;
		acc_name = name;
		acc_bal = bal;
	}
	
	void getdetail() {
		System.out.println("Account Number: "+acc_num);
		System.out.println("Account Name: "+acc_name);
		System.out.println("Account Balance: "+acc_bal);
	}
}

public class Encap {

	public static void main(String[] args) {
		Bank obj = new Bank(101,"Vlad",25000);
		obj.getdetail();
	}

}
