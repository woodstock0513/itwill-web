<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
    <%@ include file="header.jspf" %>
    <main>
        <h1>Form</h1>
        <form method="get" action="form_result.jsp">
            <div>
                <input type="text" name="username" placeholder="사용자 이름" required autofocus/> 
                <!-- input은 좌우 배열 요소니까 div 안에 넣어서 엔터처리되게 -->
            </div>
            <div>
                <input type="submit" value="제출"/>
            </div>
            <div>
                <select name="color">
                    <option value="r">빨강</option>
                    <option value="g">초록</option>
                    <option value="b">파랑</option>
                </select>
            </div>
        </form>
    </main>
</body>
</html>