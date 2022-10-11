<%@page import="hrd_score.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트 / 등록</title>
    <link rel="stylesheet" href="layout.css">
    <link rel="stylesheet" href="table.css">
</head>

<%@ include file="header.jsp" %>
<body>
<section style="min-height: 640px;">
	<h3>학생 리스트</h3>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>연락처</th>
			</tr>
<%
	@SuppressWarnings("unchecked")
	List<StudentVo> slist = (List<StudentVo>)request.getAttribute("slist");

	for(StudentVo vo : slist) {
%>						
			<tr>
				<td><%= vo.getStu_id() %></td>
				<td><%= vo.getName() %></td>
				<td><%= vo.getDept() %></td>
				<td><%= vo.getTel() %></td>
			</tr>
<%
	}
%>
		<tr>
		<td colspan="4" style="text-align: right;"><a href="3registStu.jsp">[등록]</a></td>
		</tr>
		</table>
</section>
</body>
<%@ include file="footer.jsp" %>
</html>