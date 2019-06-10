package dao;


public class Order {
	private String id; 				
	private double money; 			
	private String receiceAddress;	
	private String recviceName;		
	private String recvicePhone;	
	private int paystate;			
	private String orderTime;		
	private int userId;				
	
	public Order() {
		this.id = "";
		this.money = 0.0;
		this.receiceAddress = "";
		this.recviceName = "";
		this.recvicePhone = "";
		this.paystate = 0;
		this.orderTime = "2016-01-01 00:00:00";
		this.userId = 0;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getReceiceAddress() {
		return receiceAddress;
	}
	
	public void setReceiceAddress(String receiceAddress) {
		this.receiceAddress = receiceAddress;
	}
	
	public String getRecviceName() {
		return recviceName;
	}
	
	public void setRecviceName(String recviceName) {
		this.recviceName = recviceName;
	}
	
	public String getRecvicePhone() {
		return recvicePhone;
	}
	
	public void setRecvicePhone(String recvicePhone) {
		this.recvicePhone = recvicePhone;
	}
	
	public int getPaystate() {
		return paystate;
	}
	
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}
	
	public String getOrderTime() {
		return orderTime;
	}
	
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
