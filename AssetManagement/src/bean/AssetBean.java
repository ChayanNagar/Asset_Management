package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="add_asset")
public class AssetBean {
@Id
@GeneratedValue
int aid;
String asset;
String status;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAsset() {
	return asset;
}
public void setAsset(String asset) {
	this.asset = asset;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
