<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean scope="request" id="member" class="kr.co.yagaja.vo.Member">
   <jsp:setProperty name="member" property="*"/>
</jsp:useBean>  <!--객체 생성해서 없을경우 내용실행.  -->

<jsp:forward page="/join"/> <!--요청 디스패치 방식으로 page에 지정한 url로 이동.  -->


 