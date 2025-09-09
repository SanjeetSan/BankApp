package bankingapplication;

public class Account {
	private int accountno;
	private String holderName;
	private float balance;
	private String openedDate;
	
	public Account(int accountno,String holderName,float balance,String openedDate) {
		this.accountno=accountno;
		this.holderName=holderName;
		this.balance=balance;
		this.openedDate=openedDate;
	}
	
	//getter setter
	public int getAccountno() {
		return this.accountno;
	}
		
	public String getHolderName() {
		return this.holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName=holderName;
	}
	
	public float getBalance() {
		return this.balance;
	}
	public void setBalance(float balance) {
		this.balance=balance;
	}
	
	public String getOpenedDate() {
		return this.openedDate;
	}
	//getter setter
	
	public void deposit(float amount) {
		if(amount<=0)
				System.out.println("Invalid deposit amount !");
		else {
			balance=balance+amount;
			System.out.println("Rs. "+amount+" Has been deposited. New Balance is: "+balance);
		}	
	}
	public void withdraw(float amount) {
		if(amount<=0) 
			System.out.println("Invalid Withdraw Amount !");
		else if(amount<=balance) {
			balance=balance-amount;
			System.out.println("Rs. "+amount+" Has been withdrawn Successfully.");
			System.out.println("Current Balance: "+balance);
		}
		else 
			System.out.println("Insufficient Balance !");
	}
	//Overloading Transfer 
	public void transfer(Account to,float amount) {
		if(amount<=0)
			System.out.println("Cannot to transfer function.Insufficent Balance !");
		else if(amount>0 && amount<=balance) {
			this.balance-=amount;
			to.balance+=amount;
			System.out.println("Sucessfully Transfered Rs."+amount+" To account "+to.getAccountno());
		}
		else
			System.out.println("Transaction Failed .Please check your credintials !");
	}
	public void transfer(Account to,float amount,String remarks) {
		if(amount<=0)
			System.out.println("Cannot to transfer function.Insufficent Balance !");
		else if(amount>0 && amount<=balance) {
			this.balance-=amount;
			to.balance+=amount;
			System.out.println("Sucessfully Transfered Rs."+amount+" To account "+to.getAccountno()+"[ "+remarks+" ]");
		}
		else
			System.out.println("Transaction Failed .Please check your credintials !");
	}
	//end of overloading concepts
	
	public void ministatement() {
		System.out.println("-----Mini Statement-----");
		System.out.println("Account No: "+accountno);
		System.out.println("Holder Name: "+holderName);
		System.out.println("Balance : "+balance);
		System.out.println("Opened Date: "+openedDate);
		System.out.println("-------------------------");
	}
}