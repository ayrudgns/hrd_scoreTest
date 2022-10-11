package hrd_score.vo;

public class ScoreVo {
	private int sno;
	private String scode;
	private int unit;
	private String stu_id;
	private int jumsu;
	
	
	public ScoreVo(int sno, String scode, int unit, String stu_id, int jumsu) {
		this.sno = sno;
		this.scode = scode;
		this.unit = unit;
		this.stu_id = stu_id;
		this.jumsu = jumsu;
	}

	public ScoreVo() {

	}
	
	public int getSno() {
		return sno;
	}

	public String getScode() {
		return scode;
	}
	public int getUnit() {
		return unit;
	}
	public String getStu_id() {
		return stu_id;
	}
	public int getJumsu() {
		return jumsu;
	}
	
	
	
}
