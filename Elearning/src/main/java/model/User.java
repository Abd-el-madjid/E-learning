package model;

public class User {
	
	private String email  ;
	
	private String firstname  ;
	private String lastname  ;
	private String password  ;
	private String type  	;
	private String sex   ;
	public User( String email  ,String firstname  , String lastname  , String password  , String type  	, String sex   ) {
		// TODO Auto-generated constructor stub
		
		this.email=email;
		this.firstname=firstname;
		this.lastname=lastname;
		this.password=password;
		this.sex=sex;
		this.type=type;
	}
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
