package dao;


public class User {
	private int id;				// ����id������
	private String username;	// �û���
	private String password;	// ����
	private String gender;		// �Ա� "��"����"Ů"
	private String email;		// ����
	private String phone;		// �ֻ�
	private String introduce;	// ����˵��
	private String activeCode;	// ������
	private int state;			// �û�����״̬ 0:δ���� 1:�Ѽ���
	private String role;		// �û���ɫ���Ƿ�Ϊ����Ա ����Ա:"admin" ��Ա:""
	private String registTime;	// �û�ע��ʱ�� 2016-01-01 00:00:00""

	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.gender = "��";
		this.email = "";
		this.phone = "";
		this.introduce = "";
		this.activeCode = "";
		this.state = 0;
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