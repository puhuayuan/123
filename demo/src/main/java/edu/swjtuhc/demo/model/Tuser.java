package edu.swjtuhc.demo.model;

public class Tuser {
	private int userId;
    private String userName;
    private String passWord;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Tuser [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
    

}
