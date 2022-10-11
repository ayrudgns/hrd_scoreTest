<%@page import="java.util.List"%>
<%@page import="hrd_score.vo.ScorePrint"%>
<%@page import="hrd_score.dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stu_id = request.getParameter("stu_id");
	
	ScoreDao dao = ScoreDao.getInstance();
	List<ScorePrint> splist = dao.getScoreByStudent(stu_id);
	request.setAttribute("splist", splist);
	pageContext.forward("12stuScoreList.jsp");
%>