<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  <!--여긴 잘 모르겠음. 중복확인 도움 부탁  -->
<center><form action="/mini_project/login/forward.jsp" method="post"> 
 
  ID: <input type="text" name="memberId" size="25" ><button type="button">중복확인</button>
  PW: <input type="text" name="password" size="25"><br>
   이름: <input type="text" name="memberName" size="25"><br>
  폰넘버:<input type="text" name="phoneNumber" size="50"><br> 
  email:<input type="text" name="email" size="25"><br>
  point:<input type="text" name="point" size="25"value="0">
   <input type="submit" value="가입">
 </form></center>
</body>
</html>