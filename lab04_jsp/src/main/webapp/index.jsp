<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab04</title>
</head>
<body>
    <header>
        <h1>Contents</h1>
        <h2><%=LocalDateTime.now() %></h2>
    </header>
    <main>
        <ul>
            <li><a href = "ex1">첫번째 서블릿</a></li>
            <li><a href = "ex2">두번째 서블릿</a></li>
            <li><a href = "ex3">포워드(foward)</a></li>
            <li><a href = "ex4">리다이렉트(redirect)</a></li>
        </ul>
    </main>
</body>
</html>