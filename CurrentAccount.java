package bankingapplication;

public class CurrentAccount extends Account{
	private float overdraftLimit;
	private float servicecharges;
	
	public CurrentAccount(int overdraftLimit,float servicecharges,int accountno,String holderName,float balance,String openedDate) {
		super(accountno,holderName,balance,openedDate);
		this.overdraftLimit=overdraftLimit;
		this.servicecharges=servicecharges;
	}
	//getter setter
	public float getOverdraftLimit() {
		return this.overdraftLimit;
	}
	
	public float getSerivcecharges() {
		return this.servicecharges;
	}
	//getter setter
	@Override
	public void withdraw(float amount) {
		if(amount<=0)
			System.out.println("Insufficient Balance !");
		else if(amount<=getBalance()) 
			System.out.println("Withdraw Fail !");
		else {
			setBalance(getBalance()-amount);
			System.out.println("Rs. "+amount+"Has been withdrawn Successfully.");
			System.out.println("Current Balance: "+getBalance());
		}
	}
}
