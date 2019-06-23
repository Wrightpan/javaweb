package domain;


public class User {
	private int id;				
	private String username;	
	private String password;	
	private String gender;		
	private String email;		
	private String phone;		
	private String introduce;	
	private String activeCode;	
	private int state;			
	private String role;		
	private String registTime;	

	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.gender = "";
		this.email = "";
		this.phone = "";
		this.introduce = "";
		this.activeCode = "";
		this.state = 1;
		this.role = "";
		this.registTime = "2016-01-01 00:00:00";
	}
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass())
			return false;

        User user = (User) o;

        if (this.id == user.id) {
        	return true;
        }
        return true;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getActiveCode() {
		return activeCode;
	}
	
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRegistTime() {
		return registTime;
	}
	
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	
	

}
