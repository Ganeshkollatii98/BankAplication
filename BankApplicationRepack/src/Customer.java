import java.util.*;
public class Customer {
    static int id=1;
   private int cid;
   private int cacnt_no;
   private String name;
   private int cbalance;
   private String cpassword;
   
   private List<String> ctransectios;
	public Customer(int caid,int acnt_no,String name,int blnc,String pword) {
		this.cid=caid;
		this.cacnt_no=acnt_no;
		this.name=name;
		this.cbalance=blnc;
		this.cpassword=pword;
		this.ctransectios=new ArrayList<String>();
		ctransectios.add(0+"	"+"OpeningBalance"+"	"+getCbalance()+"	"+getCbalance());
		
	}
	public List<String> getCtransectios() {
		return ctransectios;
	}
	public void DisplayTransections() {
		
		for(String s:ctransectios)
		{
			System.out.println(s);
		}
	}
	public void setCtransectios(String ctransectios) {
		this.ctransectios.add(ctransectios);
	}
	public int getCacnt_no() {
		return cacnt_no;
	}
	public int getCbalance() {
		return cbalance;
	}
    public int getCid() {
		return cid;
	}
    public String getName() {
		return name;
	}
    public String getCpassword() {
		return cpassword;
	}
    public void setCacnt_no(int cacnt_no) {
		this.cacnt_no = cacnt_no;
	}
    public void setCbalance(int cbalance) {
		this.cbalance = cbalance;
	}
    public void setCid(int cid) {
		this.cid = cid;
	}
    public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
    
    public void setName(String name) {
		this.name = name;
	}
}
