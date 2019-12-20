package edu.swjtuhc.demo.model;

public class AdminUser {
      private int Aid;
      private String Aname;
      private String Apassword;
      
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public  String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public   String getApassword() {
		return Apassword;
	}
	public void setApassword(String apassword) {
		Apassword = apassword;
	}
	@Override
	public String toString() {
		return "AdminUser [Aid=" + Aid + ", Aname=" + Aname + ", Apassword=" + Apassword + "]";
	}
      
}
