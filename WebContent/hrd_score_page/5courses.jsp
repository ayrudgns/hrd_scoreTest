<%@page import="hrd_score.vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@page import="hrd_score.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CourseDao dao = CourseDao.getInstance();

	List<CourseVo> clist = dao.getCourses();
	request.setAttribute("clist", clist);
	pageContext.forward("6courseList.jsp");

%>