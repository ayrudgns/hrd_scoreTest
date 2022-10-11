<%@page import="hrd_score.dao.StudentDao"%>
<%@page import="hrd_score.vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
		
	StudentVo vo = new StudentVo(Integer.parseInt(request.getParameter("no")),
			request.getParameter("stu_id"), request.getParameter("name"),
			request.getParameter("dept"), request.getParameter("tel"), null);
			
	StudentDao dao = StudentDao.getInstance();
	
	int cnt = dao.regist(vo);
	out.print("<script>");
	if(cnt == 1) {
		out.print("alert('학생 등록 완료!');");
		out.print("location.href='1students.jsp';");
	} else {
		out.print("alert('학생 등록 실패!');");
		out.print("history.back();");
	}
	out.print("</script>");
%>
