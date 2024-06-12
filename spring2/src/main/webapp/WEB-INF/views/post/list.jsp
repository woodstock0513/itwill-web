<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring Legacy 2</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <c:set var="pageTitle" value="Post List" />
        <%@ include file="../fragments/header.jspf"%>
    </div>

    <table class="table table-striped table-hover">
        <thead>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성시간</th>
        </thead>
        <tbody>
            <c:forEach var="p" items="${posts }">
                <tr>
                    <td>${p.id}</td>
                    <td>
                        <c:url var="postDetailsPage" value="/post/details">
                            <c:param name="id" value="${p.id}"></c:param>
                        </c:url>
                        <a href="${postDetailsPage}">${p.title}</a>
                    </td>
                    <td>${p.author}</td>
                    <td>${p.modifiedTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>