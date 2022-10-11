<%@page import="hrd_score.dao.ScoreDao"%>
<%@page import="hrd_score.vo.ScoreVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String scode = request.getParameter("scode");
	String stu_id = request.getParameter("stu_id");
//	Integer.parseInt(request.getParameter("jumsu"));
//	점수를 입력하지 않았을 때, ""를 int 타입으로 바꿀 수가 없으므로 오류 

//	if문 활용하여 int 값 주기
	int jumsu;
	if(request.getParameter("jumsu").equals("")) {
		jumsu = 0;
	} else {
		jumsu = Integer.parseInt(request.getParameter("jumsu"));
	}
	
	ScoreVo vo = new ScoreVo(0, scode, 0, stu_id, jumsu);

	ScoreDao dao = ScoreDao.getInstance();
	
	int cnt = dao.insert(vo);
	out.print("<script>");
	if(cnt == 1) {
		out.print("alert('성적 입력 완료!');");
		out.print("location.href='9scoreForm.jsp';");
	} else {
		out.print("alert('성적 입력 실패!');");
		out.print("history.back();");
	}
	out.print("</script>");
%>