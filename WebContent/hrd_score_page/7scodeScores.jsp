<%@page import="hrd_score.vo.AverageVo"%>
<%@page import="hrd_score.vo.ScoreVo"%>
<%@page import="java.util.List"%>
<%@page import="hrd_score.dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
	ScoreDao dao = ScoreDao.getInstance();

	AverageVo avo = dao.getAvg(request.getParameter("scode"));
	List<ScoreVo> gslist = dao.getScoreByScode(request.getParameter("scode"));
	request.setAttribute("avo", avo);
	request.setAttribute("gslist", gslist);
	pageContext.forward("8scodeScoreList.jsp");
%>