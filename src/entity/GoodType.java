package entity;

public class GoodType {

	private Integer id;
	private String gtname;
	
	public GoodType() {}
	public GoodType(String gtname) {
		super();
		this.gtname = gtname;
	}
	public GoodType(Integer id, String gtname) {
		super();
		this.id = id;
		this.gtname = gtname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGtname() {
		return gtname;
	}
	public void setGtname(String gtname) {
		this.gtname = gtname;
	}
	
	
}
