package entity;

import java.util.Date;

public class Order {

	private Integer id;
	private Integer aid;
	private Date creattime;
	private String orderid;
	
	public Order() {}
	public Order(Integer aid, Date creattime, String orderid) {
		super();
		this.aid = aid;
		this.creattime = creattime;
		this.orderid = orderid;
	}
	public Order(Integer id, Integer aid, Date creattime, String orderid) {
		super();
		this.id = id;
		this.aid = aid;
		this.creattime = creattime;
		this.orderid = orderid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	
}
