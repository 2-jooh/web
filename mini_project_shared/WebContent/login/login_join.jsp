<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<center><h2>회원 가입</h2></center>
<%if(session.getAttribute("joinSuccess")!=null){ %>
<span style="color:blue;"><%=request.getAttribute("joinSuccess") %></span>
<%} %>
<% if(request.getAttribute("errorMessage")!=null){ %>
<span style="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%}//end of if %>

<center><form action="/mini_project/login/forward.jsp" method="post">
<table width="700" cellpading="0" cellspacing="0">
<tr>
<td>
<table width="700" bgcolor="#d0d4dd" border="0" cellpadding="5" cellspacing="1">
   <tr bgcolor="fffff">
   <td bgcolor="f5f5f5">ID:</td>
   <td><input type="text" name="memberId" size="25" ></td>
   <button><form action="/mini_project/check" method="post">Id중복확인
   </tr> 
   <tr bgcolor="fffff">
   <td bgcolor="f5f5f5">PW:</td>
   <td><input type="text" name="password" size="25" ></td>
   </tr> 
   <tr bgcolor="fffff">
   <td bgcolor="f5f5f5">이름:</td>
   <td><input type="text" name="memberName" size="25" ></td>
   </tr>
   <tr bgcolor="fffff">
   <td bgcolor="f5f5f5">폰넘버:</td>
   <td><input type="text" name="phoneNumber" size="25" ></td>
   </tr>
   <tr bgcolor="fffff">
   <td bgcolor="f5f5f5">email:</td>
   <td><input type="text" name="email" size="25" ></td>
   </tr>
   <tr bgcolor="fffff">
   <td bgcolor="f5f5f5">point:</td>
   <td><input type="text" name="point" size="25" ></td>
   </tr>
   <br>
      <input type="submit" value="가입">
      <input type="reset" value="다시 작성하기">
      
                                 
</table>
</form></center>

  
 
<!-- <center><form action="/mini_project/login/forward.jsp" method="post"> 
 
  ID: <input type="text" name="memberId" size="25" >
  PW: <input type="text" name="password" size="25"><br>
   이름: <input type="text" name="memberName" size="25"><br>
  폰넘버:<input type="text" name="phoneNumber" size="50"><br> 
  email:<input type="text" name="email" size="25"><br>
  point:<input type="text" name="point" size="25"value="0">
   <input type="submit" value="가입">
 </form></center> -->
</body>
</html>