package hrd_score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hrd_score.vo.AverageVo;
import hrd_score.vo.ScorePrint;
import hrd_score.vo.ScoreVo;
import jdbc.utll.OracleConnectionUill;

public class ScoreDao {
	private static ScoreDao dao = new ScoreDao();

	private ScoreDao() {
		
	}
	
	public static ScoreDao getInstance() {
		return dao;
	}
	
	// 메소드 만들기!
	
	// 1)
	public List<ScoreVo> getScoreByScode(String scode) {
		Connection con = OracleConnectionUill.connect();
		String sql = "SELECT tc.SCODE, UNIT, STU_ID, JUMSU FROM TBL_COURSE tc "
				+ "JOIN TBL_SCORE ts ON tc.SCODE = ts.SCODE "
				+ "WHERE tc.SCODE = ? "
				+ "ORDER BY STU_ID";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ScoreVo vo;
		List<ScoreVo> gslist = new ArrayList<ScoreVo>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, scode);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new ScoreVo(0, rs.getString(1), rs.getInt(2), 
						rs.getString(3), rs.getInt(4));
				gslist.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("getScoreByScode 조회 오류 : " + e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
			OracleConnectionUill.close(con, pstmt);
		}
		return gslist;
	}
	
	// 2)
	public AverageVo getAvg(String scode) {
		Connection con = OracleConnectionUill.connect();
		String sql = "SELECT COUNT(SCODE) AS CNT, AVG(JUMSU) AS JAVG "
				+ "FROM (SELECT tc.SCODE, UNIT, STU_ID, JUMSU FROM TBL_COURSE tc "
				+ "JOIN TBL_SCORE ts ON tc.SCODE = ts.SCODE) "
				+ "WHERE SCODE = ?"
				+ "GROUP BY SCODE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AverageVo vo = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scode);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new AverageVo(rs.getInt(1), rs.getDouble(2));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("getAvg 오류 : " + e.getMessage());
		} finally {
			OracleConnectionUill.close(con, pstmt);
			
		}
		return vo;
	}
	
	
	// 3)
	public int insert(ScoreVo vo) {
		String sql = "INSERT INTO TBL_SCORE (SNO, SCODE, STU_ID, JUMSU) VALUES "
				+ "(SCORE_SEQ.NEXTVAL, ?, ? ,?)";
		int cnt = 0;
		
		try (Connection con = OracleConnectionUill.connect();
				PreparedStatement pstmt = con.prepareStatement(sql))
		{
			pstmt.setString(1, vo.getScode());
			pstmt.setString(2, vo.getStu_id());
			pstmt.setInt(3, vo.getJumsu());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("성적 입력 오류 : " + e.getMessage());
		}
		return cnt;
	}
	
	// 4)
	public List<ScorePrint> getScoreByStudent(String stu_id) {
		Connection con = OracleConnectionUill.connect();
		String sql = "SELECT tc.SCODE, TITLE, UNIT, JUMSU, CASE WHEN JUMSU >= 95 THEN 'A+' "
				+ "WHEN JUMSU >= 90 THEN 'A' WHEN JUMSU >= 85 THEN 'B+' WHEN JUMSU >= 80 THEN 'B' "
				+ "WHEN JUMSU >= 75 THEN 'C+' WHEN JUMSU >= 70 THEN 'C' WHEN JUMSU >= 65 THEN 'D+' "
				+ "WHEN JUMSU >= 60 THEN 'D' ELSE 'F' END AS GRADE "
				+ "FROM TBL_COURSE tc JOIN TBL_SCORE ts ON tc.SCODE = ts.SCODE "
				+ "WHERE STU_ID = ?";
		
		PreparedStatement pstmt = null;

		List<ScorePrint> splist = new ArrayList<ScorePrint>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, stu_id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				splist.add(new ScorePrint(rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println("개인 성적표 조회 오류 :  " + e.getMessage());
		} finally {
			OracleConnectionUill.close(con, pstmt);
		}
		return splist;
		
	}
}
