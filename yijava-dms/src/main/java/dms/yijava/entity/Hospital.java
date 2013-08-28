package dms.yijava.entity;

public class Hospital {

	// 登录名称
	private String name;

	private String id;
	
	public Hospital() {
		super();
	}

	public Hospital(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
