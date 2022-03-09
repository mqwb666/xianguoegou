package entity;

import java.util.Date;

public class User {

	private Integer id;
	private String uname;
	private Integer sex;
	private Date birthday;
	private Integer age;
	private String phone;
	private String email;
	private Integer level;//等级
	private Integer role;//角色：管理员0、用户1、供应商2
	private Date uzcbirthday;
	private String pic;
	private Integer isdelete;
	
	public User() {}
	
	public User(String uname, Integer sex, Date birthday, Integer age, String phone, String email,
			Integer level, Integer role, Date uzcbirthday, String pic, Integer isdelete) {
		super();
		this.uname = uname;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.level = level;
		this.role = role;
		this.uzcbirthday = uzcbirthday;
		this.pic = pic;
		this.isdelete = isdelete;
	}
	

	public User(Integer id, String uname, Integer sex, Date birthday, Integer age, String phone, String email,
			Integer level, Integer role, Date uzcbirthday, String pic, Integer isdelete) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.level = level;
		this.role = role;
		this.uzcbirthday = uzcbirthday;
		this.pic = pic;
		this.isdelete = isdelete;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getUzcbirthday() {
		return uzcbirthday;
	}

	public void setUzcbirthday(Date uzcbirthday) {
		this.uzcbirthday = uzcbirthday;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
	
	
	

}
