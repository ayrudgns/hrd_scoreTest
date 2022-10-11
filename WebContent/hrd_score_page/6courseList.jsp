<%@page import="hrd_score.vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개설 과목 리스트</title>
    <link rel="stylesheet" href="table.css">
    <link rel="stylesheet" href="layout.css">
</head>

<%@ include file="header.jsp" %>
<body>
<section style="min-height: 640px;">
	<h3>개설과목 리스트</h3>
		<table>
			<tr>
				<td>교과목코드</td>
				<td>과목명</td>
				<td>담당교수</td>
				<td>학점</td>
				<td>성적조회</td>
			</tr>
<%
	@SuppressWarnings("unchecked")
	List<CourseVo> clist = (List<CourseVo>)request.getAttribute("clist");

	for(CourseVo vo : clist) {
%>
			<tr>
			<td><%= vo.getScode() %></td>
			<td><%= vo.getTitle() %></td>
			<td><%= vo.getTeacher() %></td>
			<td><%= vo.getUnit() %></td>
			<td><button onclick="location.href='7scodeScores.jsp?scode=<%= vo.getScode() %>'">[조회]</button></td>
			</tr>
<%
	}
%>

		</table>
	</section>
</body>
<%@ include file="footer.jsp" %>
</html>