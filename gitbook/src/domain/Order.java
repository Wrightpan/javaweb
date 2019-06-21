package domain;


public class Order {
	private String id; 				
	private double money; 			
	private String receiveAddress;	
	private String receiveName;		
	private String receivePhone;	
	private int paystate;			
	private String orderTime;		
	private int userId;				
	
	public Order() {
		this.id = "";
		this.money = 0.0;
		this.receiveAddress = "";
		this.receiveName = "";
		this.receivePhone = "";
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
	
	public String getReceiveAddress() {
		return receiveAddress;
	}
	
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	
	public String getReceiveName() {
		return receiveName;
	}
	
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	
	public String getReceivePhone() {
		return receivePhone;
	}
	
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
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
