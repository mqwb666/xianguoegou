package entity;

public class Password {

	private Integer id;
	private Integer uid;
	private String pwd;
	
	public Password() {}
	
	
	public Password(Integer uid, String pwd) {
		super();
		this.uid = uid;
		this.pwd = pwd;
	}

	public Password(Integer id, Integer uid, String pwd) {
		super();
		this.id = id;
		this.uid = uid;
		this.pwd = pwd;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
