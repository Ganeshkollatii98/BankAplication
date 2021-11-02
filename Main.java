import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class Main {
	public static Map<Integer,List<String>> ReadData() throws FileNotFoundException {
	       File myObj = new File("D:\\\\JavaPractise\\\\BankApplications\\\\src\\\\CustomerDetails.txt");
	       Scanner myReader = new Scanner(myObj);
	       Map<Integer,List<String>> PersonDict=new HashMap<>();
	       while (myReader.hasNextLine()) {
	    	   
	         String data = myReader.nextLine();
	         
	         //"\\s+" will check for spaces in string
	         List<String> SplittedData=Arrays.asList(data.split("\\s+"));
	               
	         PersonDict.put(Integer.parseInt(SplittedData.get(0)),SplittedData);
       
	       }
	       return PersonDict;
	      
	}
	
	public static Boolean ValidationForLogin(String Username,String password) throws FileNotFoundException
	{
	    Map<Integer,List<String>> customers=ReadData();	
	    
	    for(int key:customers.keySet())
	    { 
	    	
	    	 if(customers.get(key).get(2).equals(Username) && customers.get(key).get(4).equals(password)) {
	    		 
	    		 return true;
	    	 }
	    }
		return false;
		
	}
  

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan=new Scanner(System.in);
		Boolean Loop=true;
        
	    Map<Integer,List<String>> customers=ReadData();	
	   
		while(Loop)
		{
			
			System.out.println("1.Account Login \n2.Purchase \n3.Exit");
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
                   System.out.println("User Logged In");
                   Boolean innerLoop=true;
                   while(innerLoop) {

                       System.out.println("Choose any Otpion");
                       System.out.println("1.Create Gift Card \n2.Top Up \n3.Transaction History \n4.Block \n5.Logout");
                       int option=scan.nextInt();
                       switch (option) {
    				case 1: {
    					  System.out.println("Create Gift Card");
    				      break;
    				}
    				case 2:{
    					System.out.println("Top Up");
    					break;
    				}
    				case 3:{
    					System.out.println("Transaction History");
    					break;
    				}
    				case 4:{
    					System.out.println("Block");
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
			    System.out.println("Purchase");
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
