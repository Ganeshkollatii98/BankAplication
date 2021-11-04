import java.util.*;

public class Controller {
    static Map<Integer,Customer> customers=new HashMap<Integer,Customer>();
    
    public static void add_new_customer(Customer cust) {
    	customers.put(cust.getCid(), cust);
    }
    public static void get_customers_info() {
    	  for(Customer cust:customers.values()) {
    		  System.out.println(cust.getCid()+"        "+cust.getCacnt_no()+"        "+cust.getName()+"        "+cust.getCbalance()+"        "+cust.getCpassword());
    	  }
    }
    public static String get_customer(int id) {
    	 Customer cust=customers.get(id);
    	 
    	 return cust.getCid()+"		"+cust.getCacnt_no()+"		"+cust.getName()+"		"+cust.getCbalance();
    }
    public static void validationsCashWithDraw(int key,int amount) {
    	 Customer customer=customers.get(key);
    	 int availableBlnc=customer.getCbalance();
    	
    	 if(availableBlnc-amount>=1000)
    	 {
    		 customer.setCbalance(availableBlnc-amount);
    		 customer.setCtransectios(Customer.id+++"	"+"ATMWithDrawal"+"	"+amount+"	"+customer.getCbalance());
    	 }
    	 else {
    		 System.out.println("Your Customer Balance Is Limited");
    	 }
    	 
    }
    public static void validationsCashDeposit(int key,int amount) {
    	 Customer customer=customers.get(key);
    	 int availableBlnc=customer.getCbalance();
    	 customer.setCbalance(availableBlnc+amount); 
    	 customer.setCtransectios(Customer.id+++"	"+"CashDeposit"+"	"+amount+"	"+customer.getCbalance());
    }
    public static void validationsTransfer(int key,int amount,int account_no) {
    	 Customer customer=customers.get(key);
    	 int availableBlnc=customer.getCbalance(); 
    	 if(availableBlnc-amount>=1000) {
    		 customer.setCbalance(availableBlnc-amount);
        	 customer.setCtransectios(Customer.id+++"	"+"TransferedTo-"+account_no+"	"+amount+"	"+customer.getCbalance());
    	 }
    	 else {
    		 System.out.println("Your Customer Balance Is Limited");
    	 }
    }
    public static void validationsForMaintenanceFee(int key) {
    	Customer cust=customers.get(key);
    	int TransextionLength=cust.getCtransectios().size();
    	if(TransextionLength>=11)
    	{
    		cust.setCbalance(cust.getCbalance()-100);
    		cust.setCtransectios(Customer.id+++"	"+"Maintenence Fee"+"	"+100+"	"+cust.getCbalance());
    	}
    }
    public static void Top_n_Customers(int n) {
       List<Customer> cust=new ArrayList<Customer>();
       for(Customer c:customers.values()) {
    	   cust.add(c);
       }
       //cust.sort((a,b)-> a.getCbalance() > b.getCbalance());
       Collections.sort(cust,new Comparator<Customer>() {
    	    @Override
    	    public int compare(Customer a, Customer b) {
    	        return b.getName().compareTo(a.getName());
    	    }
    	});
       for(int i=0; i<cust.size(); i++) {
    	   System.out.println(cust.get(i).getCacnt_no()+"	"+cust.get(i).getName()+"	"+cust.get(i).getCbalance());
       }
       
    }
    
   
}
