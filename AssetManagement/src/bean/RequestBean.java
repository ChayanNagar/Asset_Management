package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RequestTable")
public class RequestBean {
@Id
@GeneratedValue
int rid;
int eid;
int mid,status;
int aid;
String assetname;
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAssetname() {
	return assetname;
}
public void setAssetname(String assetname) {
	this.assetname = assetname;
}

String requestDate;
public String getRequestDate() {
	return requestDate;
}
public void setRequestDate(String requestDate) {
	this.requestDate = requestDate;
}
public Date getManagerApprovedDate() {
	return managerApprovedDate;
}
public void setManagerApprovedDate(Date managerApprovedDate) {
	this.managerApprovedDate = managerApprovedDate;
}

Date managerApprovedDate;

}
