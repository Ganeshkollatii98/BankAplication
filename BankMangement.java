
public class BankMangement {
	    static int id=11;
	    int Account_No;
	    String Name;
	    int Balance;
	    String EncryptPWD;
	    int PersonId;
	    BankMangement(int act_no,String Name,int Balance,String EncryptPWD) {
			// TODO Auto-generated constructor stub
	        this.PersonId=id++;
	        this.Account_No=act_no;
	        this.Name=Name;
	        this.Balance=Balance;
	        this.EncryptPWD=EncryptPWD;
		}
        public String PasswordEncription(String Password) {
              String PasswordResult="";
              for(int i=0; i<Password.length(); i++)
              {
            	  PasswordResult+=(char)((int)Password.charAt(i)+1);  
              }
              return PasswordResult;    
        }
}
