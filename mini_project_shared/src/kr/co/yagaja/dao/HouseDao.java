package kr.co.yagaja.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.yagaja.vo.House;

public interface HouseDao {
	
	/*
	 * HOUSE 정보를 insert하는 메소드 - 관리자
	 * @param Session
	 * @param house
	 * @return
	 */
	int insertHouse(SqlSession session, House house);
	
	
	/*
	 * HOUSE 정보를 update 하는 메소드 - 관리자
	 * @param Session
	 * @param house
	 * @return
	 */
	int updateHouse(SqlSession session, House house);
	
	
	/*
	 * HOUSE 정보를 delete 하는 메소드 - 관리자
	 * @param Session
	 * @param house
	 * @return
	 */
	int deleteHouseById(SqlSession session, String houseId);
	
	
	/*
	 * 하우스 전체를 select 하는 메소드
	 * @param Session
	 * @return
	 */
	List<House> selectHouseList(SqlSession session);
	
	/*
	 * 하우스 하나만 select하는 메소드
	 * @param Session
	 * @return
	 */
	House selectHouseById(SqlSession session, String houseId);
	
	/*
	 * HOUSE에 지역을 select 하는 메소드
	 * @param Session
	 * @param loaction
	 * @return
	 */
	List<House> selectHouseByLocation(SqlSession session, String location);
	
	
	/*
	 * HOUSE의 유형과 지역을 select 하는 메소드
	 * @param Session
	 * @param pattern
	 * @param loaction
	 * @return
	 */
	List<House> selectHouseByKeyword(SqlSession session, String pattern, String location);
	
	
	/*
	 * HOUSE의 가격의 낮은 순으로 select 하는 메소드
	 */
	List<House> selectHouseByPriceLow(SqlSession session);
	
	
	/*
	 * HOUSE의 가격의 높은 순으로 select 하는 메소드
	 */
	List<House> selectHouseByPriceHigh(SqlSession session);
	
	
	
	
	
}
