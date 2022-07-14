import java.util.ArrayList;
import java.util.Iterator;
public class Agent{

	// creates array list
	private ArrayList<Client> Clients;
	


	public Agent() {
		Clients = new ArrayList<Client>();
		
	}

	// returns the length of the array list (number of clients)
	public int getNumberOfClients() {
		return Clients.size();
	}
// returns the client name alongside the number of the funds they own.
	public String getClientInfo(int ClientNumber) {
		Client c = Clients.get(ClientNumber);
		String text = "";
		text +=  c.getName() + ": £" + c.getFunds() + "\n";
		return text;
	}

// returns the client name alongside the number of the funds they own but checks wether if its a stock or not to add the '£'.
	public String getListOfClientNames() {
		String text = "";
		Iterator<Client> it = Clients.iterator();
		while (it.hasNext()) {
			Client c = it.next();
			if(c.getName().equals("Mohammad Al-Mousawi")){
				text += c.getName() + ": £" + c.getFunds() + "\n";
			}
			else{
				text += c.getName() + ": " + c.getFunds() + "\n";
			}

		}
		return text;
	}
// adds a client/stock.
	public void addClient(Client c) {
		Clients.add(c);
	}

// deposits money to clients account
	public boolean deposit(String ClientName, int amount) {
		Iterator<Client> it = Clients.iterator();
		boolean found = false;
		int num = 0;
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getName().equals(ClientName)) {
				found = true;
				c.deposit(amount);

			}
		}
		return found;
	}

// withdraws money from clients account
	public boolean withdraw(String ClientName, int amount) {
		Iterator<Client> it = Clients.iterator();
		boolean found = false;
		int num = 0;
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getName().equals(ClientName)) {
				if (amount <= c.getFunds()) {
					found = true;
					c.withdraw(amount);

				}


			}
		}
		return found;
	}

	//Iterates throguh client class to check if its a stock, then deposits the stock amount to the account and
	//assigns a value depending on the stock so it is known
	// how much money to withdraw from the clients account.
	public boolean buyStock(String ClientName, int amount) {
		Iterator<Client> it = Clients.iterator();
		Client b = Clients.get(0);
		boolean found = false;
		int num = 0;
		if (ClientName.equals("Tesla")){
			num = 1000;
		}
		else if (ClientName.equals("Amazon")){
			num = 500;
		}
		else if (ClientName.equals("Apple")){
			num = 750;
		}
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getName().equals(ClientName)) {
				if ((amount*num) <= b.getFunds()) {
					found = true;
					c.deposit(amount);
					withdraw("Mohammad Al-Mousawi",amount*num);

				}


			}
		}
		return found;
	}
//Iterates throguh client class to check if its a stock, then withdraws the stock amount from the account and
//assigns a value depending on the stock so it is known
	// how much to deposit from the clients account.
	public boolean sellStock(String ClientName, int amount) {
		Iterator<Client> it = Clients.iterator();
		Client b = Clients.get(0);
		boolean found = false;
		int num = 0;
		if (ClientName.equals("Tesla")){
			num = 1000;
		}
		else if (ClientName.equals("Amazon")){
			num = 500;
		}
		else if (ClientName.equals("Apple")){
			num = 750;
		}
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getName().equals(ClientName)) {
				if ((amount) <= c.getFunds()) {
					found = true;
					c.withdraw(amount);
					deposit("Mohammad Al-Mousawi",amount*num);

				}
			}
		}
		return found;
	}

}

