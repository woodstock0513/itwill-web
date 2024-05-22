<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<!-- include 지시문:
여러개의 페이지들이 공통된 컨텐트(헤더,푸터)를 포함하는 경우,
공통된 컨텐트를 별도의 jsp/jspf파일로 작성하고,
공통된 컨텐트가 필요한 페이지(예: main)에서 jsp/jspf 파일을 포함해서 사용
include 지시문이 사용된 위치에 jsp/jspf파일의 내용이 삽입되고
하나의 자바 클래스 코드로 변환된 후 컴파일 됨
jspf(jsp fragment): jsp의 일부, 조각!

 -->
    <%@ include file="header.jspf" %>
    <main>
        <h1>메인 페이지</h1>
    </main>
    <%@ include file="footer.jsp" %>
</body>
</html>