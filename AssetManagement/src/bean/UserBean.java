package bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserBean {
@Id
@GeneratedValue
int uid;
String fname, lname,email,active;
@Column(name="password")
String pwd;
@Column(name="designation")
String Designation;
@Column(name="mid")
int mmid;
@Column(name="eid")
int eeid;
@Column(name="sid")
int ssid;
public int getSsid() {
	return ssid;
}
public void setSsid(int ssid) {
	this.ssid = ssid;
}
long mobile;
Date doj;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getActive() {
	return active;
}
public void setActive(String active) {
	this.active = active;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}
public int getMmid() {
	return mmid;
}
public void setMmid(int mmid) {
	this.mmid = mmid;
}
public int getEeid() {
	return eeid;
}
public void setEeid(int eeid) {
	this.eeid = eeid;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}


}
