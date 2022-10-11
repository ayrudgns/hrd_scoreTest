<%@page import="hrd_score.vo.AverageVo"%>
<%@page import="hrd_score.vo.ScoreVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목별 성적 조회</title>
    <link rel="stylesheet" href="table.css">
    <link rel="stylesheet" href="layout.css">
</head>

<%@ include file="header.jsp" %>
<body>
<section style="min-height: 640px;">
	<h3>과목별 성적 조회</h3>
	<table>
	<caption style="text-align: left;">2022-1학기</caption>
		<tr>
			<th>교과목코드</th>
			<th>학점</th>
			<th>학번</th>
			<th>점수</th>
		</tr>
<%
	@SuppressWarnings("unchecked")
	List<ScoreVo> gslist = (List<ScoreVo>)request.getAttribute("gslist");
	AverageVo avo = (AverageVo)request.getAttribute("avo");

	for(ScoreVo vo : gslist) {
%>
		<tr>
			<td><%= vo.getScode() %></td>
			<td><%= vo.getUnit() %></td>
			<td><%= vo.getStu_id() %></td>
			<td><%= vo.getJumsu() %></td>
		</tr>
<%
	}
%>
	</table>
	<div style="text-align: center;">
	<p>
	총 수강 인원 : <%= (avo == null) ? 0 : avo.getCount() %> 명<br>
	과목 평균 : <%= (avo == null) ? 0.0 : avo.getAvg() %> 점
	</p>
	<button onclick="history.back()">돌아가기</button>
	</div>
	</section>
</body>
<%@ include file="footer.jsp" %>
</html>