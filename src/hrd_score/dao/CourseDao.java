package hrd_score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hrd_score.vo.CourseVo;
import jdbc.utll.OracleConnectionUill;

public class CourseDao {
	
	private static CourseDao dao = new CourseDao();
	
	private CourseDao() {
		
	}

	public static CourseDao getInstance() {
		return dao;
	}

	// 메소드 만들기!
	
	// 1)
	public List<CourseVo> getCourses() {
		
		String sql = "SELECT SCODE, TITLE, TEACHER, UNIT FROM TBL_COURSE "
				+ "ORDER BY SCODE";
		
		List<CourseVo> clist = new ArrayList<CourseVo>();
		
		try (Connection con = OracleConnectionUill.connect();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery())
		{
			
			while (rs.next()) {
				clist.add(new CourseVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), null));
			}
		} catch (SQLException e) {
			System.out.println("Course List 조회 오류 : " + e.getMessage());
		}
		return clist;	
	}
	
}
