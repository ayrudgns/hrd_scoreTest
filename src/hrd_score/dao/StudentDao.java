package hrd_score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hrd_score.vo.StudentVo;
import jdbc.utll.OracleConnectionUill;

public class StudentDao {
	
	private static StudentDao dao = new StudentDao();
	
	private StudentDao() {
		
	}
	
	public static StudentDao getInstance() {
		return dao;
	}
	
	// 메소드 만들기!
	
	// 1)
	public List<StudentVo> getStudents() {
		Connection con = OracleConnectionUill.connect();
		
		String sql = "SELECT STU_ID, NAME, DEPT, TEL FROM TBL_STUDENT";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<StudentVo> slist = new ArrayList<StudentVo>();
		
		try{
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				slist.add(new StudentVo(0, rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), null));
			}
			return slist;
		} catch (SQLException e) {
			System.out.println("Student List 조회 오류 : " + e.getMessage());			
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
			OracleConnectionUill.close(con, pstmt);
		}
		return null;
	}
	
	// 2)
	public int getNextSeq() {

		String sql = "SELECT (MAX(NO) + 1) FROM TBL_STUDENT";
		int seq = 0;
		
		try (Connection con = OracleConnectionUill.connect();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery())
		{
			if(rs.next()) {
				seq = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Next SEQ 오류 발생 : " + e.getMessage());
		}
		return seq;
	}
	
	// 3)
	public int regist(StudentVo vo) {
		String sql = "INSERT INTO TBL_STUDENT (NO, STU_ID, NAME, DEPT, TEL) VALUES "
				+ "(?, ?, ?, ?, ?)";
		int cnt = 0;
		
		try (Connection con = OracleConnectionUill.connect();
				PreparedStatement pstmt = con.prepareStatement(sql))
		{
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getStu_id());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getDept());
			pstmt.setString(5, vo.getTel());
			
			cnt = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("Student Regist 오류 발생 : " + e.getMessage());
		}
		return cnt;
	}
	
}
