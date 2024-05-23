<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language</title>
</head>
<body>
    <main>
        <h1>EL(Expression Language)</h1>
        <%--
        EL: jsp의 Expression(<%= ... %>)을 대체하는 문법
        EL 문법: ${ 식 } 
        o. 지시문 <%@ ... %> 안에서 사용 불가
        o. 선엄문 <%! ... %> 안에서 사용 불가
        o. sriptlet <% ... %> 안에서 사용 불가
        o. (표현)식 <%= ... %> 안에서 사용 불가
        o. jsp 태그를 제외한 jsp 모든 코드 안에서는 언제든지 사용 가능.
            - HTML 태그의 컨텐트나 속성 값을 설정할 때
            - CSS 속성 값 설정
            - HTML 안의 <script> 태그에 포함된 JavaScript 코드 안에서 (별도의 JS 말고!)
            - JSTL 안에서 사용 가능
        jsp의 태그들!!과 혼용 불가
         --%>
         
        <p><%= 1+1 %></p> <!-- JSP expression -->
        <p>${1+1}</p> <!-- EL -->
        
        <%-- 
        상태 저장에 사용되는 JSP 내장 객체:
        pageContext : JSP 페이지가 유지되는 동안만 정보를 저장.
        request : 요청 객체가 유지되는 동안 정보 저장
        session : 세션이 유지되는 동안 정보 저장
        application : 웹 애플리케이션이 동작하는 동안 정보 저장.
        사용 범위 : pageContext > request < session < application
        상태 저장 메서드 : setAttribute("속성이름", 속성값)
        상태 값을 읽는 메서드 : getAttribute("속성이름")
        
        1개의 request가 한 개 이상의 JSP와 연결되는 경우가잇음.
         --%>
        
        
        <%
        pageContext.setAttribute("id", 1);
        request.setAttribute("id", 2);
        session.setAttribute("id","admin");
        %>
        
        <h2>JSP expression을 사용한 상태 정보 읽기</h2>        
        <p>
        page: id = <%= pageContext.getAttribute("id") %> <br/>
        request: id = <%= request.getAttribute("id") %> <br/>
        session: id = <%= session.getAttribute("id") %> <br/>
        </p>
        
        <h2>EL을 사용한 상태 정보 읽기</h2>
        <p>
        page id: = ${ pageScope.id } <br/>
        request: id = ${ requestScope.id } <br/>
        session: id = ${ sessionScope.id } <br/>
        </p>
        <%-- 
        EL vs JSP 내장 객체
        pageScope - pageContext
        requestScope = request
        sessionScope - session
        applicationScope - application
        
        EL ${attr} 에서 상태 정보를 찾는 순서:
        (1) ${ pageScope.attr}
        (2) ${ requestScope.attr}
        (3) ${ sessionScope.attr}
        (4) ${ applicationScope.attr}
         --%>
        <p>EL: id = ${id}</p> <!-- 암것도 안 쓰면 제일 먼저 페이지에서 찾음!! -->
        
        <% request.setAttribute("username","scott"); %>
        <p>EL: id = ${username}</p> <%--${requestScope.username으로 쓸 필요가 없음!!} --%>
        
        <h2>EL 삼항 연산자</h2>
        <% pageContext.setAttribute("number",0513); %>
        <p>${ number } = ${(number%2==1) ? '홀수' : '짝수'}</p>
        
        <% session.setAttribute("loginUser", "admin"); %>
        <p>${(loginUser !=null) ? 'hello' : 'please login' } ${ loginUser }!</p>
    </main>

</body>
</html>