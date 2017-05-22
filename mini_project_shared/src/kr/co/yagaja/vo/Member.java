package kr.co.yagaja.vo;


import java.io.Serializable;
import java.util.List;

public class Member implements Serializable{

	private String memberId;
	private String password;
	private String memberName;
	private String phoneNumber;
	private String email;
	private int point;
	/***************************************************
	 * 부모테이블 : Member  자식 테이블 : Reservation
	 * 하나의 회원은 여러개의 예약정보를 가지고있음
	 * 예약정보를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<Reservation> reservationList;
	
	//constructor
	public Member() {}
	public Member(String memberId, String password, String memberName, String phoneNumber, String email,
										int point, List<Reservation> reservationList) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.point = point;
		this.reservationList = reservationList;
	}

	// Liset<Reservation> reservationList 없는 생성자 추가해야 하는것 아닌지.
	public Member(String memberId, String password, String memberName, String phoneNumber, String email,
										int point) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.point = point;
	}
	
	
	
	//getter setter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public List<Reservation> getReservationList() {
		return reservationList;
	}
	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	//toString
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", password=" + password + ", memberName=" + memberName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", point=" + point + ", reservationList="
				+ reservationList + "]";
	}
	
	//hashCode equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + point;
		result = prime * result + ((reservationList == null) ? 0 : reservationList.hashCode());
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
		Member other = (Member) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (point != other.point)
			return false;
		if (reservationList == null) {
			if (other.reservationList != null)
				return false;
		} else if (!reservationList.equals(other.reservationList))
			return false;
		return true;
	}
	
	
}
