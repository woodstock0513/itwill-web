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
            <c:set var="pageTitle" value="New Post" scope="page"/>
            <%@ include file="../fragments/header.jspf" %>
        </div>
        
        <main>
            <div class="mt-2 card">
                <div class="card-header text-center">
                    <h2>새 글 작성</h2>
                </div>
                <div class="card-body">
                    <c:url var="newPostPage" value="/post/create" />
                    <form action="${newPostPage}" method="post">
                        
                        <div class="mt-2">
                            <input class="form-control" type="text" name="title" placeholder="제목을 입력하세요" required autofocus />
                        </div>
                        
                        <div class="mt-2">
                            <textarea class="form-control" rows="5" name="content" placeholder="내용을 입력하세요" required="required"></textarea>
                        </div>
                        
                        <div class="mt-2 d-none">
                            <input class="form-control" type="text" name="author" value="${signedInUser}"/>
                        </div>
                        
                        <div class="mt-2">
                            <input class="form-control btn btn-outline-success" type="submit" value="저장"/>
                        </div>
                        
                    </form>
                </div>
            </div>    
        
        </main>
             
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
    </html>