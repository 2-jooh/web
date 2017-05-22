<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.yagaja.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


 <% if(((Member)session.getAttribute("loginInfo"))!=null){ %>
 <center><span style="color:blue;"><h1>로그인 성공</h1><br>
 <%=((Member)session.getAttribute("loginInfo")).getMemberName()%>님 환영합니다.</span></center>  
<%}else{ %> 
 <center><span style="color:blue;"><h1>회원가입 성공</h1><br>
 <%=session.getAttribute("joinInfo")%>님 가입을 축하드립니다.</span></center>
 <%}%>
 

<p>
 <a href="/mini_project/login/login_form.jsp">메인페이지</a>
 <a href="/mini_project/logout">로그아웃</a>
</body>
</html>