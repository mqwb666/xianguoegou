package entity;

import java.util.Date;

public class Supplier {

	private Integer id;
	private String sname;
	private String content;
	
	private Integer uid;
	
	
	private String province;
	private String city;
	private String county;
	private String contentaddress;
	private Integer level;
	private String pic;
	private Date uzcbirthday;
	private Integer ischeck;
	private Integer isdelete;
	
	public Supplier() {}
	
	public Supplier(String sname, String content, Integer uid, String province, String city, String county,
			String contentaddress, Integer level, String pic, Date uzcbirthday, Integer ischeck, Integer isdelete) {
		super();
		this.sname = sname;
		this.content = content;
		this.uid = uid;
		this.province = province;
		this.city = city;
		this.county = county;
		this.contentaddress = contentaddress;
		this.level = level;
		this.pic = pic;
		this.uzcbirthday = uzcbirthday;
		this.ischeck = ischeck;
		this.isdelete = isdelete;
	}
	
	public Supplier(Integer id, String sname, String content, Integer uid, String province, String city, String county,
			String contentaddress, Integer level, String pic, Date uzcbirthday, Integer ischeck, Integer isdelete) {
		super();
		this.id = id;
		this.sname = sname;
		this.content = content;
		this.uid = uid;
		this.province = province;
		this.city = city;
		this.county = county;
		this.contentaddress = contentaddress;
		this.level = level;
		this.pic = pic;
		this.uzcbirthday = uzcbirthday;
		this.ischeck = ischeck;
		this.isdelete = isdelete;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getContentaddress() {
		return contentaddress;
	}
	public void setContentaddress(String contentaddress) {
		this.contentaddress = contentaddress;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getUzcbirthday() {
		return uzcbirthday;
	}
	public void setUzcbirthday(Date uzcbirthday) {
		this.uzcbirthday = uzcbirthday;
	}
	public Integer getIscheck() {
		return ischeck;
	}
	public void setIscheck(Integer ischeck) {
		this.ischeck = ischeck;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
	
	
	
}
