package kr.co.yagaja.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.yagaja.dao.HouseDao;
import kr.co.yagaja.dao.impl.HouseDaoImpl;
import kr.co.yagaja.util.SqlSessionFactoryManager;
import kr.co.yagaja.vo.House;

public class HouseService {
	
	private SqlSessionFactory factory;
	
	public HouseService() throws IOException	{
		SqlSessionFactoryManager manager = SqlSessionFactoryManager.getInstance();
		factory = manager.getSqlSessionFactory();
	}
	 
	
	public void testHouse() throws IOException	{
		
		HouseDao dao = HouseDaoImpl.getInstance();
		SqlSession session = null;
		House house = null;
		List<House> list = null;	
		
		try{
			session =  SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			
			//insert
			System.out.println("------------HOUSE 추가------------");
			House p1 = new House("p1", "펜션", "경기", "경기펜션", 100000, null, 0);
			dao.insertHouse(session, p1);
			House h1 = new House("h1", "호텔", "경기", "경기호텔", 120000, null , 1);
			dao.insertHouse(session, h1);
			
			//update
			System.out.println("------------HOUSE update------------");
			House pu1 = new House("p1", "호텔", "인천", "인천펜션", 110000, null, 999);
			dao.updateHouse(session, pu1);
			
			
			//delete
//			System.out.println("------------HOUSE delete------------");
//			dao.deleteHouseById(session, "p1");
			
			
			//전체 조회
			list = dao.selectHouseList(session);
			System.out.println(list);
			
			
			//지역 조회
			String location = "성남";
			list = dao.selectHouseByLocation(session,location);
			System.out.println(list);
			printHouseList(list, "인천조회");
			
			//지역,유형 조회
			list = dao.selectHouseByKeyword(session, "호텔", "성남");
			System.out.println("유형 / 지역 검색");
			System.out.println(list);
			
			list = dao.selectHouseByKeyword(session, null, "경기");
			printHouseList(list, "지역 검색");

			//낮은순 조회
			list = dao.selectHouseByPriceLow(session);
			printHouseList(list, "낮은 순 조회");
			
			//높은순  조회
			list = dao.selectHouseByPriceHigh(session);
			printHouseList(list, "높은 순 조회");
			
			
			
			session.commit();
		}
		finally{
			session.close();
		}
	}
	
	public void printHouseList(List<House> list, String label){
		System.out.printf("---------------------------------%s---------------------------------%n", label);
		for(House house : list){
			System.out.printf("사진NO: %d, 숙소ID : %s, 유형 : %s, 숙소이름 : %s, 주소 : %s, 가격 : %d%n", 
					house.getPictureNo(),house.getHouseId(),house.getType(),house.getHouseName(),house.getLocation(),house.getPrice());
		}
		
		System.out.println("===========================================");
	}
	


	
	
	
	public static void main(String[] args) throws IOException	{
		HouseService exam = new HouseService();
		exam.testHouse();
	}
}
