package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_login")
public class AdminBean {
@Id
@Column(name="username")	
String uname;
@Column(name="pwd")
String password;
public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
