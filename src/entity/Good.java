package entity;

import java.util.Date;

public class Good {

	private Integer id;
	
	private Integer gid;
	
	private String gname;
	private String content;
	private Integer nownumber;
	private Integer number;
	private Date lasttime;
	
	private Integer sid;
	
	private Double price;
	private String pic;
	private Integer ismarket;
	
	public Good() {}
	
	
	public Good(Integer gid, String gname, String content, Integer nownumber, Integer number, Date lasttime,
			Integer sid, Double price, String pic, Integer ismarket) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.content = content;
		this.nownumber = nownumber;
		this.number = number;
		this.lasttime = lasttime;
		this.sid = sid;
		this.price = price;
		this.pic = pic;
		this.ismarket = ismarket;
	}

	public Good(Integer id, Integer gid, String gname, String content, Integer nownumber, Integer number, Date lasttime,
			Integer sid, Double price, String pic, Integer ismarket) {
		super();
		this.id = id;
		this.gid = gid;
		this.gname = gname;
		this.content = content;
		this.nownumber = nownumber;
		this.number = number;
		this.lasttime = lasttime;
		this.sid = sid;
		this.price = price;
		this.pic = pic;
		this.ismarket = ismarket;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNownumber() {
		return nownumber;
	}

	public void setNownumber(Integer nownumber) {
		this.nownumber = nownumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getIsmarket() {
		return ismarket;
	}

	public void setIsmarket(Integer ismarket) {
		this.ismarket = ismarket;
	}
	
	
	
	
	
	
}
