package hrd_score.vo;

public class ScorePrint {
	private String scode;
	private String title;
	private int unit;
	private int jumsu;
	private String grade;
	
	public ScorePrint() {

	}
	
	public ScorePrint(String scode, String title, int unit, int jumsu, String grade) {
		this.scode = scode;
		this.title = title;
		this.unit = unit;
		this.jumsu = jumsu;
		this.grade = grade;
	}
	
	public String getScode() {
		return scode;
	}
	public String getTitle() {
		return title;
	}
	public int getUnit() {
		return unit;
	}
	public int getJumsu() {
		return jumsu;
	}
	public String getGrade() {
		return grade;
	}
	
	
	
}
