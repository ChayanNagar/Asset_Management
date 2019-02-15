package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_login")
public class AdminBean {
@Id

@Column(name="password")
String pwd;
String Designation;
int aaid;
public int getAaid() {
	return aaid;
}

public void setAaid(int aaid) {
	this.aaid = aaid;
}

public String getDesignation() {
	return Designation;
}

public void setDesignation(String designation) {
	Designation = designation;
}


public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}


}
