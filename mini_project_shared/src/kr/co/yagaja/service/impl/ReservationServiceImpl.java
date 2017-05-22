package kr.co.yagaja.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.yagaja.dao.ReservationDao;
import kr.co.yagaja.dao.impl.MemberDaoImpl;
import kr.co.yagaja.dao.impl.ReservationDaoImpl;
import kr.co.yagaja.util.SqlSessionFactoryManager;

public class ReservationServiceImpl {
	private ReservationDao dao;
	private SqlSessionFactory factory;
	private static ReservationService instance;
	
	private MemberServiceImpl() throws IOException{
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = ReservationDaoImpl.getInstance();
	}

}
