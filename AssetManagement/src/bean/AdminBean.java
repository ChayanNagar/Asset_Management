package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_login")
public class AdminBean {
@Id
@Column(name="email_id")	
String email;
@Column(name="password")
String pwd;
String Designation;
public String getDesignation() {
	return Designation;
}

public void setDesignation(String designation) {
	Designation = designation;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}


}
