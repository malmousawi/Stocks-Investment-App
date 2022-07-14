
public class Account{
    private int balance;
    private int stocks;
    
    public Account(){
        this.balance=0;
        this.stocks = 0;
    }    

    public Account(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }    

    public void deposit(int amount){
        this.balance += amount;
    }
    public int getStockNumber(){
        return this.stocks;
    }

    public void depositStock(int amount){
        this.stocks += amount;
    }

    public void withdraw(int amount){
        this.balance -= amount;
    }

    public String toString(){
	return "Balance: " + this.balance;
    }
    
}
