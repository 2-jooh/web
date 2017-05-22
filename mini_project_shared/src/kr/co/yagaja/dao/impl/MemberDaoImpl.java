package kr.co.yagaja.dao.impl;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.yagaja.dao.MemberDao;
import kr.co.yagaja.vo.Member;

public class MemberDaoImpl implements MemberDao {

		// 싱글톤
		private static MemberDaoImpl instance;

		public MemberDaoImpl() {
		} //LoginServlet 에서의 MemberDaoImpl 객체생성할때 private-> public으로 바꿈

		public static MemberDaoImpl getInstance(){
			if (instance == null){
				instance = new MemberDaoImpl();
			}
			return instance;
		}
	
		
		
	@Override
	public List<Member> selectMemberList(SqlSession session) {
		return session.selectList("kr.co.yagaja.config.mapper.memberMapper.selectMemberList"); 
	}
	
	@Override
	public Member selectMemberById(SqlSession session, String MemberId) {
		return session.selectOne("kr.co.yagaja.config.mapper.memberMapper.selectMemberById",MemberId); 

	}
	
	@Override
	public int insertMember(SqlSession session, Member member) {
		return session.insert("kr.co.yagaja.config.mapper.memberMapper.insertMember", member);
	}
	
   
	
	
	

}
