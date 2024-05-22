<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form_Result</title>
<style>
    <%
    //질의 문자열에 포함된 요청 파라미터의 값을 찾음
    String color = request.getParameter("color");
    String textColor = "";
    switch (color){
    case "r":
        textColor = "crimson";
        break;
    case "g":
        textColor = "darkgreen";
        break;
    case "b":
        textColor = "slateblue";
        break;
    default:
        textColor="black";   
    }
    %>
span#username{
    color: <%= textColor%>
}
</style>
</head>
<body>
<%@ include file="header.jspf" %>
    <h1>폼 제출 결과</h1>
    <!--JSP 내장 객체
    jsp 파일이 자바코드로 변환될 때 _jspService(request, response   ) 메서드 안에서 선언된 지역 변수들
    sciptlet에서 지역 변수로 선언할 수 없음!!!
    request: 클라이언트에서 서버로 보내는 요청 정보들과 메서드를 가지고 있는 객체
        - getParameter(), ...
    response: 서버에서 응답을 만들 때 사용되는 객체
        - setContentType(), sendRedirect(), ...
    out: JSP writer. HTML 코드 작성 기능을 가지고 있는 객체
        - write(), print(), ...
    pageContext: JSP page가 유지되는 동안 정보를 저장하기 위한 객체
    session: 세션이 유지되는 동안 정보를 저장하기 위한 객체 (로그인 상태 유지 등)
    application: 웹 애플리케이션이 동작 중에 유지되는 정보를 저장하기 위한 객체
    config: 서블릿의 환경설정 정보를 저장하는 객체
     -->
    <%
    String username = request.getParameter("username");
    %>
    <h2>안녕하세요, <span id="username"><%= username %></span></h2>
    
    <% if (username.equals("admin")){ %>
        <h3>관리자 페이지</h3>
    
    <% } else { %>
        <h3>일반 사용자 페이지</h3>
    <% } %>
    
    
</body>
</html>