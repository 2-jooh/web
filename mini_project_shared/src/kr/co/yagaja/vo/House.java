package kr.co.yagaja.vo;

import java.io.Serializable;
import java.util.List;

public class House implements Serializable {
	private String houseId;
	private String type;
	private String location;
	private String houseName; 
	private long price;
	/***************************************************
	 * 부모테이블 : House  자식 테이블 : Reservation
	 * 하나의 하우스는 여러개의 예약정보를 가지고있음
	 * 예약정보를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<Reservation> reservationList;	
	
	/***************************************************
	 * 부모테이블 : House  자식 테이블 : Picture
	 * 하나의 House 테이블은 여러개의 Picture 테이블과 연결
	 * 사진 정보를 저장할 인스턴수변수 선언
	 ***************************************************/
	private List <Picture> pictureList;
	
	//constructor
	public House() {}	
	public House(String houseId, String type, String location, String houseName, long price,
			List<Reservation> reservationList, List<Picture> pictureList) {
		super();
		this.houseId = houseId;
		this.type = type;
		this.location = location;
		this.houseName = houseName;
		this.price = price;
		this.reservationList = reservationList;
		this.pictureList = pictureList;
	}



	//getter setter
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public List<Reservation> getReservationList() {
		return reservationList;
	}
	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", type=" + type + ", location=" + location + ", houseName=" + houseName
				+ ", price=" + price + ", reservationList=" + reservationList + ", pictureList=" + pictureList + "]";
	}
	
	
	//hashCode equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((houseId == null) ? 0 : houseId.hashCode());
		result = prime * result + ((houseName == null) ? 0 : houseName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pictureList == null) ? 0 : pictureList.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + ((reservationList == null) ? 0 : reservationList.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		House other = (House) obj;
		if (houseId == null) {
			if (other.houseId != null)
				return false;
		} else if (!houseId.equals(other.houseId))
			return false;
		if (houseName == null) {
			if (other.houseName != null)
				return false;
		} else if (!houseName.equals(other.houseName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (pictureList == null) {
			if (other.pictureList != null)
				return false;
		} else if (!pictureList.equals(other.pictureList))
			return false;
		if (price != other.price)
			return false;
		if (reservationList == null) {
			if (other.reservationList != null)
				return false;
		} else if (!reservationList.equals(other.reservationList))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	
	
	}
	
}