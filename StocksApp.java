
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class StocksApp extends Frame{

   // Starting message
    private static TextArea infoArea = new TextArea("Welcome To The Investment App");

    public static void print(String text){
	infoArea.setText(text);
    }    

    
    private Agent agent;
    private Panel ClientButtonsPanel;


	// checks and outputs wether deposit, withdraw, buy or sell is successfull or unsuccessfull.

	public void deposit(String n, int a){
		boolean valid = agent.deposit(n,a);
		if(valid !=  true){
			print("Deposit Unsuccessfull");
		}
		else{
			print("Deposit Successfull");
		}
	}

	public void withdraw(String name, int amount){
		boolean valid = agent.withdraw(name,amount);
		if(valid != true){
			print("Withdraw Unsuccessfull");
		}
		else{
			print("Withdraw Successfull");
		}
	}
	public void buy(String name, int amount){
		boolean valid = agent.buyStock(name,amount);
		if(valid != true){
			print("Purchase Unsuccessfull");
		}
		else{
			print("Purchase Successfull");
		}
	}
	public void sell(String name, int amount){
		boolean valid = agent.sellStock(name,amount);
		if(valid != true){
			print("Sell Unsuccessfull");
		}
		else{
			print("Sell Successfull");
		}
	}


    public void printClients(){
	String text = agent.getListOfClientNames();
	print(text);
    }

  
    public void printClientInfo(int index){
	String text = agent.getClientInfo(index);
	print(text);	
    }
	

    public void addClient(String name){
	agent.addClient(new Client(name));



	int numOfClients = agent.getNumberOfClients();
	Button btn = new Button("Client " + numOfClients);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn){
					printClientInfo(numOfClients-1);
				}

			}
		});

	this.setVisible(false); 
    }
	public void addStock(String name){
		agent.addClient(new Client(name));

		// Uncomment for R3
		int numOfClients = agent.getNumberOfClients();
		Button btn = new Button("Client " + numOfClients);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn){
					printClientInfo(numOfClients-1);
				}

			}
		});

		this.setVisible(false); 
	}


	public StocksApp(){

	this.agent = new Agent();	
	this.setLayout(new FlowLayout());
	
	// Button to view instructions
		Button homeButton=new Button("View Instructions");
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				print("Welcome to The Investment Trading App. In this App you will have the ability to View" + "\n " +
						"your Portfolio, Buy securities, Sell securities, Deposit funds and Withdraw funds. Use " + "\n" +
						"the features provided to navigate through the app and perform necessary tasks. For the purpose" + "\n" +
						"of this Investment App you will be allocated with the Account 'Mohammad Al-Mousawi'" + "\n" +
						"and starting amount of £500.");

			}
		});
		this.add(homeButton);

		// Button to view portfolio
		Button reportButton=new Button("View Portfolio");
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reportButton){
					printClients();
				}

			}
		});

	this.add(reportButton);


		// Button to deposit and uses try and catch to make sure an integer was inputed.
        Button depositButton = new Button("Deposit");
		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				TextField b = new TextField("Deposit Amount: ");
				acp.add(b);

				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						try{
							int amount = Integer.parseInt(b.getText());
							deposit("Mohammad Al-Mousawi",amount);
						}
						catch (Exception e){
							print("Input must be an Integer");
						}

					}
				});


				acp.activate();
			}
		});

		this.add(depositButton);

// Button to withdraw and uses try and catch to make sure an integer was inputed.
		Button withdrawButton = new Button("Withdraw");
		withdrawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				TextField b = new TextField("Withdraw Amount: ");
				acp.add(b);

				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						try{
							int amount = Integer.parseInt(b.getText());
							withdraw("Mohammad Al-Mousawi",amount);
						}
						catch (Exception e){
							print("Input must be an Integer");
						}

					}
				});

				//...

				acp.activate();
			}
		});

		this.add(withdrawButton);

// Button to buy stocks and prints stocks' prices, also uses try and catch to check if an integer is inputted.
		Button buyButton = new Button("Buy Securities");
		buyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				print(agent.getClientInfo(0)+ "\n" +"Tesla: £1000 per Share" + "\n" + "Amazon: £500 per Share" + "\n" + "Apple: £750 per Share");
				Prompt acp = new Prompt();
				TextField a = new TextField("Enter Security name: ");
				acp.add(a);
				TextField b = new TextField("Buy Amount: ");
				acp.add(b);

				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						String name = a.getText();
						try{
							int amount = Integer.parseInt(b.getText());
							buy(name,amount);
						}
						catch (Exception e){
							print("Input must be an Integer");
						}


					}
				});

				//...

				acp.activate();
			}
		});

		this.add(buyButton);
// Button to sell stocks and prints stocks' prices, also uses try and catch to check if an integer is inputted.
		Button sellButton = new Button("Sell Securities");
		sellButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				print(agent.getClientInfo(0)+"\n" +"Tesla: £1000 per Share" + "\n" + "Amazon: £500 per Share" + "\n" + "Apple: £750 per Share");
				Prompt acp = new Prompt();
				TextField a = new TextField("Enter Security name: ");
				acp.add(a);
				TextField b = new TextField("Sell Amount: ");
				acp.add(b);

				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						String name = a.getText();
						try{
							int amount = Integer.parseInt(b.getText());
							sell(name,amount);
						}
						catch (Exception e){
							print("Input must be an Integer");
						}

					}
				});

				//...

				acp.activate();
			}
		});

		this.add(sellButton);
// Button that access the text file to print the stocks' prices from last year.
		Button viewLastYearButton = new Button("View Last Year Stock Prices");
		viewLastYearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				try {
					BufferedReader inputStream = new BufferedReader(new FileReader("lastYear.txt"));
					String l = inputStream.readLine() + "\n"+inputStream.readLine() + "\n"+inputStream.readLine() + "\n"
							+inputStream.readLine() + "\n"+inputStream.readLine() + "\n";
					print(l);
					inputStream.close();
				}catch (Exception e) {
					print("Error occured");
				}
			}
			
		});
		this.add(viewLastYearButton);




	infoArea.setEditable(false);
	this.add(infoArea);	


	ClientButtonsPanel = new Panel();
	ClientButtonsPanel.setLayout(new GridLayout(0,1));
	ClientButtonsPanel.setVisible(true);
	this.add(ClientButtonsPanel);

	
	// Adding the client and the stocks to act as a client 
	this.addClient("Mohammad Al-Mousawi");
	this.addClient("Tesla");
	this.addClient("Apple");
	this.addClient("Amazon");

	deposit("Mohammad Al-Mousawi",500);

	// This allows the window to close by pressing 'X'
	addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            dispose();
        }
    });

	this.setSize(500,500);
	this.setLocationRelativeTo(null); 
	this.setVisible(true);

    }
    
    public static void main(String[] args){
	new StocksApp();
    }
}
