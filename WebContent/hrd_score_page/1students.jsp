<%@page import="hrd_score.vo.StudentVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="hrd_score.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDao dao = StudentDao.getInstance();

	// 리스트 가져오고, 애트리뷰트 주고, 페이지콘텍스트!
	List<StudentVo> slist = dao.getStudents();
	request.setAttribute("slist", slist);
	pageContext.forward("2studentList.jsp");
%>



