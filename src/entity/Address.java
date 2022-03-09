package entity;

public class Address {

	private Integer id;
	private String province;
	private String city;
	private String county;
	private String content;
	private Integer uid;

	public Address() {}
	
	public Address( String province, String city, String county, String content, Integer uid) {
		super();
		this.province = province;
		this.city = city;
		this.county = county;
		this.content = content;
		this.uid = uid;
	}

	public Address(Integer id, String province, String city, String county, String content, Integer uid) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.county = county;
		this.content = content;
		this.uid = uid;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	
	
	
}
