package kr.co.yagaja.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.yagaja.vo.Reservation;

/**
 * 
 * Member 테이블 관련 SQL처리 Dao인터페이스
 *
 */

public interface ReservationDao {

	/**
	 * 하나의 예약정보를 삭제하는 delete메소드 (mypage예약내역에서 예약취소할때)
	 * @param session, rentNo
	 * @return
	 * @작성자 - 이주현
	 */
	int deleteReservationByRentNo(SqlSession session, int rentNo);
	
	
	/**
	 * 예약정보를 추가하는 insert메소드 (숙소상세페이지에서 예약할때)
	 * @param session, memberId, houseId
	 * @return
	 * @작성자
	 */
	int insertReservation(SqlSession session);
}











