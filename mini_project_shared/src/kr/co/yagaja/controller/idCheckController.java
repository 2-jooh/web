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

public class idCheckController extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String id = req.getParameter("memberId");
		System.out.println(id);
		MemberService service = MemberServiceImpl.getInstance();
		HttpSession session = req.getSession();

		
		try {
			String s = service.idDuplicationCheck(id);
			session.setAttribute("joinSuccess", s);
			resp.sendRedirect("/mini_project/login/login_join.jsp");
		} catch (IdDuplicationException | IdCheckSuccessException | IdNullException e) {
			req.setAttribute("errorMessage", e.getMessage());
			req.getRequestDispatcher("/login/login_join.jsp").forward(req, resp);

		}

	}
}
