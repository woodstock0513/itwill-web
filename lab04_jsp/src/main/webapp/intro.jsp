<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- page 지시문 trimDirectiveWhitespaces 속성:
JSP 파일이 자바 코드로 변환되는 과정에서 JSP 태그들이 빈 줄로 대체되는데,
이를 삭제할(true) 것인지, 냅둘(false) 건지를 설정하는 속성



--%>
    
    
<%-- 
JSP 주석
1. Servlet(Server + Applet) : WAS에서 실행되는, 요청을 처리하고 응답을 보내는 작은 자바 프로그램
(1) 서블릿 객체의 생성과 관리, 서블릿 메서드 호출은 WAS가 담당
(2) 서블릿의 동작 방식:
    o. 최초 요청 -> 서블릿 객체 생성(생성자 호출) -> 메서드(doGet, doPost) 호출 -> 응답
    o. (두번째 요청 이후) 요청 -> 생성되어있는 서블릿 객체의 메서드 호출 -> 응답
2. JSP(Java/Jakarta Server Page) 
(1) 서블릿은 순수 자바 코드이기 때문에 html 작성이 매~우 불편함
-> html 형식의 파일에서 필요한 부분만 자바코드들이 실행될 수 있도록 만든 "server-side" 문법
(2) jsp 파일은 클라이언트로 전달되는게 아님!! html이 전달되는 것이기 때문에 jsp가 html 코드를 만들어야함!
-> 서버에서 실행됨
(3) JSP 동작 원리:
    o. 최초 요청 -> jsp 파일을 java 파일로 변환 -> java 코드를 class로 컴파일
    -> 객체 생성 -> 메서드 호출 -> 응답
    o. (두번째 요청 이후) 요청 -> 메서드 호출 -> 응답
3. JSP의 구성요소 (문법)
(1) 주석 (comment) : jsp 파일이 java 코드로 변환될 때 무시되는 코드 <%--    
(2) 지시문(directive) <%@ ... %>
    JSP 페이지 설정, 컨텐트 타입, 인코딩, 옵션들을 설정. java import 구문
(3) 선언문(declaration): <%! ... %>
    jsp파일이 자바 코드로 변환될 때 클래스의 필드, 메서드 선언 부분
(4) 스크립트릿(scriptlet): <% ... %>
    jsp파일이 자바 코드로 변환될 때 _jspService(req, res) 메서드 안에 포함되는 자바 코드
    지역 변수 선언 & 초기화, 메서드 호출, 조건문, 반복문, ...
(5) 식, 표현식(expression): <%= ... %>
    jsp 파일이 java 코드로 변환될 때, out.write() 메서드의 아규먼트로 전달되는 값.
    HTML 코드에 문자열을 삽입할 때 사용.     
--%>
 
<%! 
/* JSP declaration(선언문)
java 주석도 쓸 수 있음*/
private static final String USER = "scott"; //static 상수 필드 선언

//ㅁ서드 선언:
private void printLog(String msg){
	System.out.println("[intro.jsp] "+msg);
}
%>

<% /*scriptlet*/
printLog("intro.jsp 실행.."); //이클립스 콘솔에 나옴
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP..</title>
</head>
<body>
    <nav>
        <a href="/lab04">indexpage</a>
    </nav>
    <h1>JSP 소개</h1>
    
    <% //scriptlet
    LocalDateTime now =LocalDateTime.now(); //지역변수 선언, 초기화
    String date = String.format("%d-%02d-%02d", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
    String time = String.format("%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
    %>
    <h2>날짜 : <%= date%></h2> <!-- expression -->
    <h2>시간 : <%= time%></h2>
    <h2>user : <%= USER %></h2>
</body>
</html>