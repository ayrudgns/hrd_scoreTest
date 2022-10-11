<%@page import="hrd_score.vo.ScorePrint"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="table.css">
    <link rel="stylesheet" href="layout.css">
</head>

<%@ include file="header.jsp" %>
<body>
<%
	@SuppressWarnings("unchecked")
	List<ScorePrint> splist = (List<ScorePrint>)request.getAttribute("splist");
	String stu_id = (String)request.getParameter("stu_id");
%>
<section style="min-height: 640px;">
 	<form action="11studentScore.jsp" method="post">
 		<table>
 			<tr>
 			<td>학번</td>
 			<td><input name="stu_id" value="<%= (stu_id == null) ? "" : stu_id %>"></td>
 			<td><button onclick="valid_check3()">[조회]</button></td>
			</tr>
 		</table>
 	</form>

	<h3>개인 성적표</h3>
		<table>
			<tr>
				<td>교과목 코드</td>
				<td>과목명</td>
				<td>단위학점</td>
				<td>점수</td>
				<td>결과</td>
			</tr>

<%
	for(ScorePrint sp : splist) {
%>
			<tr>
				<td><%= sp.getScode() %></td>
				<td><%= sp.getTitle() %></td>
				<td><%= sp.getUnit() %></td>
				<td><%= sp.getJumsu() %></td>
				<td><%= sp.getGrade() %></td>
			</tr>		
<%
	}
%>
		</table>
</section>
</body>
<script src="validform.js"></script>
<%@ include file="footer.jsp" %>

</html>