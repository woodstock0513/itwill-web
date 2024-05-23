<%@ page import="com.itwill.lab04.model.Contact"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
    <%@ include file="header.jspf" %>
    <main>
        <h1>JSTL(JSP Standard Tag Library)</h1>
        <%-- JSTL 라이브러리 사용하기
        1. pom.xml 파일에 의존성(dependency)을 추가
            - jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api-3.0.0
            - org.glassfish.web:jakarta.servlet.jsp.jstl3.0.1
        2. JSTL을 사용하는 JSP 파일에서 <%@ taglib prefix="" uri=""%> 지시문을 설정.
         --%>
         
         
         <%
         String[] sns = {"insta", "facebook", "x"};
         pageContext.setAttribute("sns", sns); // 속성이름을 sites로 바꾸면 jstl 부분도 바꿔줘야함
         %>
        <h2>scriptlet, expression을 사용한 리스트</h2>
        <ul>
            <% for (String s : sns) { %>
                <li><%= s %></li>
            <% } %>
        </ul>
        
        <h2>JSTL, EL을 사용한 리스트</h2>
        <ul>
            <c:forEach items="${ sns }" var="s"> <%-- var이 items 앞에 있어도 무관. --%>
                <li>${ s }</li>
            </c:forEach>
        </ul>
        
        <%
        ArrayList<Contact> data = new ArrayList<>();
        for (int i = 1; i<11; i++){
        	   data.add(new Contact(i, "name_"+i, "phone_"+i*10, "email_"+i*100));
        }
        pageContext.setAttribute("contactlist", data);
        %>
        
        <h2>scriptlet, expression을 사용한 table</h2>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                <% for (Contact c : data) {%>
                    <tr>
                        <td><%= c.getId() %></td>
                        <td><%= c.getName() %></td>
                        <td><%= c.getPhone() %></td>
                        <td><%= c.getEmail() %></td>
                    </tr>
                <% } %>
            </tbody>
        
        </table>
            
        
        <h2>JSTL, EL을 사용한 table</h2>
        
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ contactlist }" var="c">
                    <tr>
                        <td>${c.id }</td> <%-- 이게 곧 getter 호출 --%>
                        <td>${c.name }</td> <%-- EL은 프로퍼티 이름으로 getter 메서드를 찾음! --%>
                        <td>${c.phone }</td> <%-- 근데,, getter, setter 이상하게 만들면 잘 안됨 --%>
                        <td>${c.email }</td> <%-- 아까 앞에서 _id 햇던 것처럼 --%>
                    </tr>
                </c:forEach>
            </tbody>
        
        </table>
        
        
    </main>
</body>
</html>