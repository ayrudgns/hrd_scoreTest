<%@page import="hrd_score.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
    <link rel="stylesheet" href="table.css">
    <link rel="stylesheet" href="layout.css">
</head>
  <%@ include file="header.jsp" %>

<body>
  <section style="min-height: 640px;">
  <%
  	StudentDao dao = StudentDao.getInstance();
  	int seq = dao.getNextSeq();
  %>
  	<h3>학생 등록</h3>
	<form action="4registSave.jsp" method="post">
		<table>
			<tr>
				<td>순번(NO)</td>
				<td><input name="no" type="number" value="<%= seq %>" readonly></td>				
			</tr>
			<tr>
				<td>학번</td>
				<td><input name="stu_id"></td>
			</tr>
			<tr>
				<td>성명</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>학과</td>
				<td><input name="dept"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input name="tel"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
				<button onclick="valid_check()">[등록]</button>
				<button type="button" onclick="location.href='1students.jsp'">[조회]</button>
				</td>
			</tr>
		</table>
	</form>
	</section>
	<script src="validform.js"></script>
</body>
	<%@include file="footer.jsp" %>
</html>