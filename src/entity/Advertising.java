package entity;

import java.util.Date;

public class Advertising {

	private Integer id;
	private String adname;
	private String content;
	private Integer gid;
	private String pic;
	private Date creattime;
	private Integer ismarket;
	
	public Advertising() {}
	public Advertising(String adname, String content, Integer gid, String pic, Date creattime,
			Integer ismarket) {
		super();
		this.adname = adname;
		this.content = content;
		this.gid = gid;
		this.pic = pic;
		this.creattime = creattime;
		this.ismarket = ismarket;
	}
	public Advertising(Integer id, String adname, String content, Integer gid, String pic, Date creattime,
			Integer ismarket) {
		super();
		this.id = id;
		this.adname = adname;
		this.content = content;
		this.gid = gid;
		this.pic = pic;
		this.creattime = creattime;
		this.ismarket = ismarket;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public Integer getIsmarket() {
		return ismarket;
	}
	public void setIsmarket(Integer ismarket) {
		this.ismarket = ismarket;
	}
	
	
}
