package hrd_score.vo;

public class StudentVo {
	private int no;
	private String stu_id;
	private String name;
	private String dept;
	private String tel;
	private String password;
	
	public StudentVo() {

	}
	
	public StudentVo(int no, String stu_id, String name, String dept, String tel, String password) {
		this.no = no;
		this.stu_id = stu_id;
		this.name = name;
		this.dept = dept;
		this.tel = tel;
		this.password = password;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
}


