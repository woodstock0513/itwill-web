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
        <c:set var="pageTitle" value="마이페이지" scope="page"/>
        <%@ include file="../fragments/header.jspf" %>
            <div class="card mt-2">
                <div class="card-header">
                    <h2>${signedInUser}님의 정보 확인하기</h2>
                </div> 
                
                <div class="card-body">
                    <c:url var="myPage" value="/user/mypage"></c:url>
                    <form method="post" action="${myPage}">
                        
                        <div>
                            <a>내 포인트 : <span>${user.points}</span></a>
                        </div>
                        <div>
                            <a>내 이메일 : <span>${user.email}</span></a>
                        </div>
                        <div class="mt-2">
                            <input type="password" name="password2" required autofocus placeholder="현재 비밀번호를 입력하세요" class="form-control"/>
                        </div>
                        <div class="mt-2">
                            <input type="password" name="changePassword" required placeholder="변경할 비밀번호를 입력하세요" class="form-control"/>
                        </div>
                        <div class="mt-2">
                            <input type="password" name="changePassword2" required placeholder="변경할 비밀번호를 다시 입력하세요" class="form-control"/>
                        </div>
                        <div class="mt-2">
                            <input type="submit" value="비밀번호 변경" class="form-control btn btn-outline-success"/>
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