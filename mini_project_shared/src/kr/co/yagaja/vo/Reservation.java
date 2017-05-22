package kr.co.yagaja.vo;

import java.util.Date;

public class Reservation {
	private int rentNo;
	private Date startRentDate;
	private Date endRentDate;
	private Date rentTime;
	/***************************************************
	 * 부모테이블 : House, Member  자식 테이블 : Reservation
	 * 예약 정보 하나는 하나의 하우스와 하나의 회원을 가
	 * 예약 정보에서 어떤 하우스와 어떤 회원을 참조하고있는지를 저장할 인스턴수변수 선언
	 ***************************************************/
	private String houseId;
	private House house;
	private String memeberId;
	private Member member;
	
	//constructor
	public Reservation() {}
	public Reservation(int rentNo, Date startRentDate, Date endRentDate, Date rentTime, String houseId, House house,
												String memeberId, Member member) {
		this.rentNo = rentNo;
		this.startRentDate = startRentDate;
		this.endRentDate = endRentDate;
		this.rentTime = rentTime;
		this.houseId = houseId;
		this.house = house;
		this.memeberId = memeberId;
		this.member = member;
	}
	
	//getter setter
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public Date getStartRentDate() {
		return startRentDate;
	}
	public void setStartRentDate(Date startRentDate) {
		this.startRentDate = startRentDate;
	}
	public Date getEndRentDate() {
		return endRentDate;
	}
	public void setEndRentDate(Date endRentDate) {
		this.endRentDate = endRentDate;
	}
	public Date getRentTime() {
		return rentTime;
	}
	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
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
	public String getMemeberId() {
		return memeberId;
	}
	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	//toString
	@Override
	public String toString() {
		return "Reservation [rentNo=" + rentNo + ", startRentDate=" + startRentDate + ", endRentDate=" + endRentDate
				+ ", rentTime=" + rentTime + ", houseId=" + houseId + ", house=" + house + ", memeberId=" + memeberId
				+ ", member=" + member + "]";
	}
	
	//hashCode equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endRentDate == null) ? 0 : endRentDate.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((houseId == null) ? 0 : houseId.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((memeberId == null) ? 0 : memeberId.hashCode());
		result = prime * result + rentNo;
		result = prime * result + ((rentTime == null) ? 0 : rentTime.hashCode());
		result = prime * result + ((startRentDate == null) ? 0 : startRentDate.hashCode());
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
		Reservation other = (Reservation) obj;
		if (endRentDate == null) {
			if (other.endRentDate != null)
				return false;
		} else if (!endRentDate.equals(other.endRentDate))
			return false;
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
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (memeberId == null) {
			if (other.memeberId != null)
				return false;
		} else if (!memeberId.equals(other.memeberId))
			return false;
		if (rentNo != other.rentNo)
			return false;
		if (rentTime == null) {
			if (other.rentTime != null)
				return false;
		} else if (!rentTime.equals(other.rentTime))
			return false;
		if (startRentDate == null) {
			if (other.startRentDate != null)
				return false;
		} else if (!startRentDate.equals(other.startRentDate))
			return false;
		return true;
	}
	
	
}
