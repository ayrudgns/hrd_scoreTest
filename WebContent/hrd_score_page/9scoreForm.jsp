<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 등록</title>
    <link rel="stylesheet" href="table.css">
    <link rel="stylesheet" href="layout.css">
</head>
  <%@ include file="header.jsp" %>
<body>
	<section style="min-height: 640px;">
  	  	<h3>성적 입력</h3>
  	  	<form action="10score.jsp" method="post">
		<table>
			<tr>
				<td>교과목코드</td>
				<td><input name="scode"></td>				
			</tr>
			<tr>
				<td>학번</td>
				<td><input name="stu_id"></td>
			</tr>
			<tr>
				<td>점수</td>
				<td><input type="number" name="jumsu" value="0"></td>
				<td><button onclick="valid_check2()">[저장]</button></td>
			</tr>
		</table>	
		</form>
	</section>

<script src="validform.js"></script>
</body>
	<%@include file="footer.jsp" %>
</html>