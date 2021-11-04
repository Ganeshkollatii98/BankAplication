import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bank {
	static int cust_logged_id;
	public static Boolean ValidationForLogin(String username,String password) {
		Map<Integer,Customer> cust=Controller.customers;
		
		for(Customer c:cust.values())
		{
			
			if(c.getName().equals(username) && c.getCpassword().equals(password))
			{
				
				int key=c.getCid();
				cust_logged_id=key;
				System.out.println("Hello "+c.getName() +" Thanks of logging..");
				System.out.println("");
				System.out.println("Your Details");
				System.out.println(Controller.get_customer(cust_logged_id));
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		//Adding Customers 
		Controller.add_new_customer(new Customer(11, 11011, "Kumar", 10000, "Kum123"));
		Controller.add_new_customer(new Customer(12, 11012, "Madhu", 20000, "Mad123"));
		Controller.add_new_customer(new Customer(13, 11013, "Rahul", 30000, "Rah123"));
		Controller.add_new_customer(new Customer(14, 11014, "Robin", 40000, "Rob123"));
		System.out.println();
		
		Scanner scan=new Scanner(System.in);
		Boolean Loop=true;
//        Controller.get_customers_info();
	   
		while(Loop)
		{
			
			System.out.println("1.Account Login \n2.Top n Customers \n3.Exit");
			int userOption=scan.nextInt();
			switch(userOption)
			{
			case 1:{
				
				System.out.println("....Enter The USERNAME & PASSWORD Credentials....");
				//AppipNbjm
				//Kumar
				String username=scan.next();
				String password=scan.next();
				
				if(ValidationForLogin(username,password))
				{
                   Boolean innerLoop=true;
                   //BankMangement Bank=new BankMangement();
                   while(innerLoop) {
                	   if(Customer.id>=11)
                	   {
                		   Controller.validationsForMaintenanceFee(cust_logged_id);
                	   }
                       System.out.println("");
                       System.out.println("Choose any Otpion");
                       System.out.println("1.Cash Withdraw \n2.Cash Deposit \n3.Account Transfer \n4.Transaction History \n5.Logout");
                       System.out.println("");
                       int option=scan.nextInt();
                       switch (option) {
    				case 1: {
    					  System.out.println("Enter Amount To WithDraw");
    					  int cash=scan.nextInt();
    					  Controller.validationsCashWithDraw(cust_logged_id,cash );
    					 
    				      break;
    				}
    				case 2:{
    					System.out.println("Enter Amount To Deposit");
    					int cash=scan.nextInt();
    					Controller.validationsCashDeposit(cust_logged_id, cash);
    					break;
    				}
    				case 3:{
                        System.out.println("Enter Account Number");
                        int acnt_no=scan.nextInt();
    					System.out.println("Enter Amount To Transfer");
    					int cash=scan.nextInt();
    					Controller.validationsTransfer(cust_logged_id, cash, acnt_no);
    					break;
    				}
    				case 4:{
    					 Customer cust=Controller.customers.get(cust_logged_id);
    					 System.out.println("TransID	TransType	Amount	Balance");
   					     cust.DisplayTransections();
    					break;
    				}
    				case 5:{
    					System.out.println("Logout");
    					innerLoop=false;
    					break;
    				}
    				default:
    					System.out.println("You need to enter correct option");
    				}
    				
                   }
                   
				}
				else {
					System.out.println("username or password will be wrong");
				}

				 break;
				}	
			case 2:{
				System.out.println("Top n Customers");
				
			    Controller.Top_n_Customers(5);
			    System.out.println("");
				break;	
			}
			case 3:{
			    System.out.println("Logout");
			    Loop=false;
				break;	
			}
			}
			}


	}

}
