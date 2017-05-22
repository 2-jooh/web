<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


.d1 {
   /* float: center; */
    position: relative;
    top: 100px;
    width: 100%;
    margin-right: 0%;
    padding: 100px 0;
    background-color: rgb(0,200,255);
    color: white;
    text-align: center;
}

.d2 {
    float: left;
    top: 500px;
    width: 100%;
    padding: 80px 0;
    background-color: #ffb5b4;
    color: #fa8382;
    text-align: center;
}
.d3{

    top:250px;
    width:50%;
    color:black;
    text-align:left;
}
.d4{
    top: 10px;
    width: 10000px;
    border: 25px solid green;
    padding: 25px;
    margin: 0px;
}


.d5 {
    top: 100px;
    width: 10000px;
    padding: 10px;
    border: 5px solid gray;
    margin: 0;
}
.d8{
 top: 100px;
    width: 10000px;
    padding: 10px;
    border: 5px solid gray;
    margin: 0;
}
.threesteps{float:left; padding:10px;width 33%; border: 25px solid green;}
</style>

</head>
<body>
<h1><center><em>Ya Ga Ja</em></center></h1>  

<div class="d3"><h4>로그인 폼</h4></div>

<%if(request.getAttribute("errorMessage")!=null){ %>
<span style="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%}//end of if %>
<div class="d5"><form action="/mini_project/login" method="post">  
   ID: <input type="text" name="memberId" size="25">
   PW: <input type="text" name="password" size="25">
   <input type="submit" value="로그인"><button><a href="/mini_project/login/login_join.jsp">회원가입</a></button>
  </form></div>

<div class="threesteps"> 
   &nbsp; &nbsp; 지역 검색&nbsp; &nbsp; &nbsp;
 <select name="category" >  <!--name 옆에 multiple   -->
       <option value="r1">안양시  </option>
       <option value="r2">시흥시</option>
       <option value="r3">안산시</option>
       
       
      </select>
</div>

<div class="threesteps">
  &nbsp; &nbsp; 숙박유형 검색&nbsp; &nbsp; &nbsp;
 <select name="category" >  <!--name 옆에 multiple   -->
       <option value="t1">팬션  </option>
       <option value="t2">모텔</option>
       <option value="t3">호텔</option>
       
      </select>
</div>
</body>
</html>