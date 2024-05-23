<%@page import="com.itwill.lab04.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
<style type="text/css">
    p{
        border: 1px solid olive;
        border-radius: 8px;
        margin: 16px;
        padding: 14px;
    }
</style>
</head>
<body>
    <%@ include file="header.jspf" %>
    <main>
        <h1>JSP Action Tag</h1>
        <%--
        JSP 액션 태그 : 스크립트릿에서 사용되는 일부 자바 코드들을 HTML 또는 XML과 비슷하게
        태그, 태그 속성(attribute), 태크 컨텐트를 작성해서 대체하는 문법
        JSP action tag는 대/소문자를 구분함!! (HTML 태그는 대소문자를 구분하지 않음) 
        o. <jsp:forward></jsp:forward>
        o. <jsp:include></jsp:include>
        o. <jsp:useBean></jsp:useBean> : 객체 생성자 호출
        o. <jsp:getProperty></jsp:getProperty> : getter 메서드 호출
        o. <jsp:setProperty><jsp:setProperty> : setter 메서드 호출 
         --%>
        <h2>action tag를 사용하지 않은 자바 객체 생성</h2>
        <% 
        Contact contact1 = new Contact(); //기본 생성자 호출
        contact1.setId(1); //setter 메서드 호출
        contact1.setName("gil dong");
        contact1.setPhone("010-1234-5678");
        contact1.setEmail("hong@naver.com");
        %>
        <p>
        ID: <%= contact1.getId() %> <br/> <!-- getter 메서드 호출 -->
        name: <%= contact1.getName() %> <br/>
        phone: <%= contact1.getPhone() %> <br/>
        email: <%= contact1.getEmail() %> <br/>
        </p>
        
        <h2>action tag java Bean을 사용한 객체 생성</h2>
        <jsp:useBean id="contact2" class="com.itwill.lab04.model.Contact" />
        <%-- Contact contact2 = new Contact(); 랑 똑같음!!
        -> 기본 생성자 없으면 액션태그도 동작하지 않음,,,
        --%>
        <jsp:setProperty property="id" name="contact2" value="2"/>
        <%-- contact1.setId(1); 랑 똑같음!! --%>
        <jsp:setProperty property="name" name="contact2" value="moon"/>
        <jsp:setProperty property="phone" name="contact2" value="010-0513-2002"/>
        <jsp:setProperty property="email" name="contact2" value="moon@naver.com"/>
        
        <p>
        ID: <jsp:getProperty property="id" name="contact2"/> <br/>
        <%-- ID: <%= contact1.getId() 랑 똑같음!! --%>
        name: <jsp:getProperty property="name" name="contact2"/> <br/>
        phone: <jsp:getProperty property="phone" name="contact2"/> <br/>
        email: <jsp:getProperty property="email" name="contact2"/>
        
        </p>
        
    </main>
    
    <jsp:include page="footer.jsp"></jsp:include>
    <%-- <%@ include file = "" %>와 비슷하지만 JSP파일들이 각각 컴파일된 후 합쳐짐. jspf는 사용 X --%>
    

</body>
</html>