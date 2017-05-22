package kr.co.yagaja.vo;

import java.io.Serializable;
import java.util.List;

public class Picture implements Serializable
{
	private int pictureNo;
	private String pictureName;
	/***************************************************
	 * 부모테이블 : House  자식 테이블 : Picture
	 * 하나의 House 테이블은 여러개의 Picture 테이블과 연결
	 * 하우스 정보를 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String houseId;
	private House house;
	
	//constructor
	public Picture() {}	
	public Picture(int pictureNo, String pictureName, String houseId, House house) {
		super();
		this.pictureNo = pictureNo;
		this.pictureName = pictureName;
		this.houseId = houseId;
		this.house = house;
	}

	
	//getter setter	
	public int getPictureNo() {
		return pictureNo;
	}
	public void setPictureNo(int pictureNo) {
		this.pictureNo = pictureNo;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	//toString
	@Override
	public String toString() {
		return "Picture [pictureNo=" + pictureNo + ", pictureName=" + pictureName + ", houseId=" + houseId + ", house="
				+ house + "]";
	}
	
	
	//hashCode equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((houseId == null) ? 0 : houseId.hashCode());
		result = prime * result + ((pictureName == null) ? 0 : pictureName.hashCode());
		result = prime * result + pictureNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (houseId == null) {
			if (other.houseId != null)
				return false;
		} else if (!houseId.equals(other.houseId))
			return false;
		if (pictureName == null) {
			if (other.pictureName != null)
				return false;
		} else if (!pictureName.equals(other.pictureName))
			return false;
		if (pictureNo != other.pictureNo)
			return false;
		return true;
	}	
	

	
}
