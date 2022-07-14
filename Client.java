public class Client extends User {
     
    private Account account;

    // This class deposits, withdraws and accesses the balance of the clients class.

    public Client(String name){
	super(name);
	this.account = new Account();
    }

    public void deposit(int amount){
	this.account.deposit(amount);
    }

    public void withdraw(int amount){
	this.account.withdraw(amount);
    }

    public int getFunds(){
	return this.account.getBalance();
    }

}
