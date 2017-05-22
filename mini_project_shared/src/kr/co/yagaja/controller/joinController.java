package kr.co.yagaja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.yagaja.exception.IdCheckSuccessException;
import kr.co.yagaja.exception.IdDuplicationException;
import kr.co.yagaja.exception.IdNullException;
import kr.co.yagaja.service.MemberService;
import kr.co.yagaja.service.impl.MemberServiceImpl;
import kr.co.yagaja.vo.Member;

public class joinController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException {

		
		Member member = (Member) req.getAttribute("member");
		MemberService service = MemberServiceImpl.getInstance();
		HttpSession session = req.getSession();

				
		  try{
			  try {
				service.joinMemberById(member);
			} catch (IdCheckSuccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  session.setAttribute("joinInfo", member.getMemberId());
			  session.setAttribute("loginInfo", null);
				resp.sendRedirect("/mini_project/login/login_success.jsp");//요청 디스패치로 하면 새로고침할떄 똑같은거 계속 실행하므로 같은 회원 계속 등록

		  }catch(IdDuplicationException|IdNullException e ){
			
			 req.setAttribute("errorMessage", e.getMessage());;
			 req.getRequestDispatcher("/login/login_join.jsp").forward(req, resp);

		  }
				
	}		
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

