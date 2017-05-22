
package kr.co.yagaja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.yagaja.exception.LoginFailException;
import kr.co.yagaja.service.MemberService;
import kr.co.yagaja.service.impl.MemberServiceImpl;
import kr.co.yagaja.vo.Member;

public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("memberId");
		String password = req.getParameter("password");

		try {
			MemberService service = MemberServiceImpl.getInstance();
			Member member = service.loginProcess(id, password);
			// 로그인 성공- session생성 -> login_success.jsp로 이동
			HttpSession session = req.getSession();
			// 로그인 여부를 체크할 속성값 session에 추가.
			session.setAttribute("loginInfo", member);
			req.getRequestDispatcher("/login/login_success.jsp").forward(req, resp);
		} catch (LoginFailException e) {
			req.setAttribute("errorMessage", e.getMessage()); // 응답하면 관리할 필요없는
			req.getRequestDispatcher("/login/login_form.jsp").forward(req, resp);// 다시
																					// 돌아오는것.
		}
	}

}
