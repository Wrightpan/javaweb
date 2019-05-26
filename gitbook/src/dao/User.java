package dao;

/*
 * 鐢ㄦ埛绫� 瀵瑰簲鏁版嵁琛╱ser锛岃〃缁撴瀯鍙煡鐪媎b.sql鏂囦欢
 * @author: luoxn28
 * @date: 2016.5.13
 */
public class User {
	private int id;				// 鑷id锛屼富閿�
	private String username;	// 鐢ㄦ埛鍚�
	private String password;	// 瀵嗙爜
	private String gender;		// 鎬у埆 "鐢�"鎴栬��"濂�"
	private String email;		// 閭
	private String phone;		// 鎵嬫満
	private String introduce;	// 涓汉璇存槑
	private String activeCode;	// 婵�娲荤爜
	private int state;			// 鐢ㄦ埛婵�娲荤姸鎬� 0:鏈縺娲� 1:宸叉縺娲�
	private String role;		// 鐢ㄦ埛瑙掕壊锛屾槸鍚︿负绠＄悊鍛� 绠＄悊鍛�:"admin" 浼氬憳:""
	private String registTime;	// 鐢ㄦ埛娉ㄥ唽鏃堕棿 2016-01-01 00:00:00""

	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.gender = " ";
		this.email = "";
		this.phone = "";
		this.introduce = "";
		this.activeCode = "";
		this.state = 1;
		this.role = "";
		this.registTime = "2016-01-01 00:00:00";
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
