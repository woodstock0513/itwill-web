<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lab 05</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <main>
        <c:set var="pageTitle" value="로그인" scope="page"/>
        <%@ include file="../fragments/header.jspf" %>
            <div class="card mt-2">
                <div class="card-header">
                    <h2>로그인</h2>
                </div> 
                <div class="card-body">
                    <c:url var="signInPage" value="/user/signin"></c:url>
                    <form method="post" action="${signInPage}">
                        <div class="mt-2">
                            <input type="text" name="userid" required autofocus placeholder="id를 입력하세요" class="form-control"/>
                        </div>
                        <div class="mt-2">
                            <input type="password" name="password" required placeholder="password를 입력하세요" class="form-control"/>
                        </div>
                        <div class="mt-2">
                            <input type="submit" value="로그인" class="form-control btn btn-outline-success"/>
                        </div>
                    </form>
                </div>           
            </div>
        
        </main>
    </div>
         
         
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>