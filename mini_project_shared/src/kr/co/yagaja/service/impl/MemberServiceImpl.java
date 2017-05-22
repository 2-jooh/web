package kr.co.yagaja.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.yagaja.dao.MemberDao;
import kr.co.yagaja.dao.impl.MemberDaoImpl;
import kr.co.yagaja.exception.IdCheckSuccessException;
import kr.co.yagaja.exception.IdDuplicationException;
import kr.co.yagaja.exception.IdNullException;
import kr.co.yagaja.exception.LoginFailException;
import kr.co.yagaja.service.MemberService;
import kr.co.yagaja.util.SqlSessionFactoryManager;
import kr.co.yagaja.vo.Member;

public class MemberServiceImpl implements MemberService {

	private ArrayList<Member> memberList;
	private ArrayList<String> checkList;
	private MemberDao dao;
	private SqlSessionFactory factory;
	private static MemberService instance;

	private MemberServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = MemberDaoImpl.getInstance();
		memberList = new ArrayList<Member>();
		checkList = new ArrayList<String>();
	}

	public static MemberService getInstance() throws IOException {

		if (instance == null) {
			instance = new MemberServiceImpl();
		}
		return instance;
	}

	@Override
	public Member loginProcess(String id, String password) throws LoginFailException, IOException {

		SqlSession sqlsession = factory.openSession(true);
		Member member = dao.selectMemberById(sqlsession, id);
		try {
			if (member != null) {
				if (password.equals(member.getPassword())) {

					return member;
				} else {
					throw new LoginFailException("패스워드를 확인하세요");
				}
			} else {

				throw new LoginFailException("ID를 확인하세요");
			}
		} finally {
			sqlsession.close();
		}
	}

	@Override
	public int joinMemberById(Member member) throws IdDuplicationException, IdNullException, IdCheckSuccessException {
		SqlSession sqlsession = factory.openSession(true);
		try {
			if (member.getMemberId() == null) {
				throw new IdNullException("Id를 입력하세요(join)");
			} else if (memberList.size() == 0) {
				memberList.add(member);
				return new MemberDaoImpl().insertMember(sqlsession, member);

			} else {
				for (int i = 0; i < memberList.size(); i++) {
					if (memberList.get(i).getMemberId().equals(member.getMemberId())) {
						throw new IdDuplicationException("ID가 중복되었습니다.");
					}
				}
				memberList.add(member);
				return new MemberDaoImpl().insertMember(sqlsession, member);
			}
		} finally {
			sqlsession.close();
		}
	}

	public String idDuplicationCheck(String id)
			throws IdDuplicationException, IdCheckSuccessException, IdNullException, IOException {
		SqlSession sqlsession = factory.openSession(true);

		String s = "Id사용 가능합니다.";
		try {
			if (id == null) {
				throw new IdNullException("Id를 입력하세요(id)");
			} else if (checkList.size() == 0) {
				checkList.add(id);
				return s;

			} else {
				for (int i = 0; i < checkList.size(); i++) {
					if (checkList.get(i).equals(id)) {

						throw new IdDuplicationException("ID가 중복되었습니다.");
					}
				}
				checkList.add(id);
				return s;

			}

		} finally {
			sqlsession.close();
		}

	
	}

}
