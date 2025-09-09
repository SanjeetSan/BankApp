package bankingapplication;

public class SavingsAccount extends Account{
	private float intrestRate;
	private float minBalance;
	
	public SavingsAccount(float intrestRate,float minBalance,int accountno,String holderName,float balance,String openedDate) {
		super(accountno,holderName,balance,openedDate);
		this.intrestRate=intrestRate;
		this.minBalance=minBalance;
	}
	
	//getter setter
	public float getIntrestRate() {
		return this.intrestRate;
	}	
	public float getMinBalance() {
		return this.minBalance;
	}
	//end of getter setter
	@Override
	public void withdraw(float amount) {
		if(amount<=0) 
			System.out.println("Invalid Withdraw Amount !");
		else if(getBalance()-amount<minBalance) 
			System.out.println("Withdrawl Denied !");
		else {
			setBalance(getBalance()-amount);
			System.out.println("Rs. " + amount + " has been withdrawn successfully.");
	        System.out.println("Current Balance: " + getBalance());
		}	
	}
	public void intrestrate() {
		float intrest =getBalance()*(intrestRate/100);
		setBalance(getBalance()+intrest);
	    System.out.println("Interest of Rs. " + intrest + " added. New Balance: " + getBalance());
	}
}