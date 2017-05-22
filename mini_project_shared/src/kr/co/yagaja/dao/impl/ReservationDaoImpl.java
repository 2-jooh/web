package kr.co.yagaja.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.yagaja.dao.ReservationDao;
import kr.co.yagaja.vo.Reservation;

public class ReservationDaoImpl implements ReservationDao {
	
	
	private ReservationDaoImpl(){}
	private static ReservationDaoImpl instance = new ReservationDaoImpl();
	public static ReservationDaoImpl getInstance(){
		return instance;
	}
	
	private String makeSqlId(String id){
		return "kr.co.yagaja.config.mapper.reservationMapper."+id;
	}
	
	@Override
	public int deleteReservationByRentNo(SqlSession session, int rentNo) {
		return session.delete(makeSqlId("deleteReservationByRentNo"));
	}

	@Override
	public int insertReservation(SqlSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

}
