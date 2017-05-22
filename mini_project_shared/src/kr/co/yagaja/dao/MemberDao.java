package kr.co.yagaja.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.yagaja.vo.Member;
/*
 * 
 * Member 테이블 관련 SQL처리 Dao인터페이스
 *  @author 김형주
 *
 */
public interface MemberDao {

	/*
	 * 직원 Id로 한명의 회원을 조회하는 메소드
	 * 회원의 전체 정보와 
	 * 
	 * @param MemberId 조회할 회원 ID
	 * @return 조회한 직원정보
	 */
	
	 //static 해야하나???????
	 Member selectMemberById(SqlSession session,String MemberId); 
		// TODO Auto-generated method stub
	
		// TODO Auto-generated method stub
		
	
	/*
	 * 전체 직원 정보를 조회하는 메소드.
	 * 조회 직원 정보는 소속부서 정보를 제외한 직원정보만 조회(DEPARTMENT-JOIN안함.)
	 * @return
	 */
	List<Member> selectMemberList(SqlSession session);
	
	
	
	 int insertMember(SqlSession session, Member member) ;
	
	
	
	
}
