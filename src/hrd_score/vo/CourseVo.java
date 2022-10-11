package hrd_score.vo;

public class CourseVo {
	private String scode;
	private String title;
	private String teacher;
	private int unit;
	private String openterm;
	
	public CourseVo() {
	}
	
	public CourseVo(String scode, String title, String teacher, int unit, String openterm) {
		this.scode = scode;
		this.title = title;
		this.teacher = teacher;
		this.unit = unit;
		this.openterm = openterm;
	}
	
	public String getScode() {
		return scode;
	}
	public String getTitle() {
		return title;
	}
	public String getTeacher() {
		return teacher;
	}
	public int getUnit() {
		return unit;
	}
	public String getOpenterm() {
		return openterm;
	}
}
