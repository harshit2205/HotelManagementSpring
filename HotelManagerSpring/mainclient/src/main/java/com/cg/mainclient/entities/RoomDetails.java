package com.cg.mainclient.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomdetails")
public class RoomDetails {

	@Id
	@Column(name="room_id")
	private String roomId; //room_id
	@Column(name="hotel_id")
	private String hotelId; //hotel_id
	@Column(name="room_no")
	private String roomNo; //room_no
	@Column(name="room_type")
	private String roomType; //room_type
	@Column(name="per_night_rate")
	private float perNightRate; //per_night_rate
	@Column(name="availability")
	private int availability;//availability
	
	//constructors parameterized and non parameterized....


	public RoomDetails() {
		super();
	}

	public RoomDetails(String hotel_id, String room_id, String room_no, String room_type, float per_night_rate,
			int availability) {
		super();
		this.hotelId = hotel_id;
		this.roomId = room_id;
		this.roomNo = room_no;
		this.roomType = room_type;
		this.perNightRate = per_night_rate;
		this.availability = availability;
	}

	//to String function....
	@Override
	public String toString() {
		return "____________________________\nRoom Id: "+roomId+"\t Room No: "+roomNo
				+"\nRoom Type: "+roomType
				+"\nPer Night Rate: Rs."+perNightRate+"\n____________________________";
	}

	//getters and setters.....
	public String getHotel_id() {
		return hotelId;
	}

	public void setHotel_id(String hotel_id) {
		this.hotelId = hotel_id;
	}

	public String getRoom_id() {
		return roomId;
	}

	public void setRoom_id(String room_id) {
		this.roomId = room_id;
	}

	public String getRoom_no() {
		return roomNo;
	}

	public void setRoom_no(String room_no) {
		this.roomNo = room_no;
	}

	public String getRoom_type() {
		return roomType;
	}

	public void setRoom_type(String room_type) {
		this.roomType = room_type;
	}

	public float getPer_night_rate() {
		return perNightRate;
	}

	public void setPer_night_rate(float per_night_rate) {
		this.perNightRate = per_night_rate;
	}

	public int isAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	
	
}
