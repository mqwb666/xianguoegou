package entity;

public class OrderMore {

	private Integer id;
	private Integer gid;
	private Integer omnumber;
	private Integer oid;
	
	public OrderMore() {}
	public OrderMore(Integer gid, Integer omnumber, Integer oid) {
		super();
		this.gid = gid;
		this.omnumber = omnumber;
		this.oid = oid;
	}
	public OrderMore(Integer id, Integer gid, Integer omnumber, Integer oid) {
		super();
		this.id = id;
		this.gid = gid;
		this.omnumber = omnumber;
		this.oid = oid;
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
	public Integer getOmnumber() {
		return omnumber;
	}
	public void setOmnumber(Integer omnumber) {
		this.omnumber = omnumber;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	
}
