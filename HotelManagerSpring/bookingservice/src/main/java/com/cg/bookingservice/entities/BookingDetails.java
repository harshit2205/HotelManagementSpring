package com.cg.bookingservice.entities;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="bookingdetails")
public class BookingDetails {
    
	@Id
	@Column(name="booking_id")
	private String bookingId;  //booking_id
	@Column(name="room_id")
	private String roomId;  //room_id
	@Column(name="user_id")
	private String userId;  //user_id
	@Column(name="booked_from")
	private Date startDate;   //booked_from
	@Column(name="booked_to")
	private Date endDate;  //booked_to
	@Column(name="no_of_adults")
	private Integer adultCount; //no_of_adults
	@Column(name="no_of_children")
	private Integer childrenCount; //no_of_children
	@Column(name="amount")
	private Float amount; //amount
	
	String booked_to_String;
	String booked_from_String;
	
	
	
	public void setBooked_to_String(Date endDate) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
		this.booked_from_String = df.format(endDate);
	}
	
	public void setBooked_from_String(Date startDate) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
		this.booked_to_String = df.format(startDate);
	}
	
	//constructor parameterized and non parameterized....
	public BookingDetails(String booking_id, String room_id, String user_id,
			Date booked_from, Date booked_to, Integer no_of_adults,
			Integer no_of_children, Float amount) {
		super();
		this.bookingId = booking_id;
		this.roomId = room_id;
		this.userId = user_id;
		this.startDate = booked_from;
		this.endDate = booked_to;
		this.adultCount = no_of_adults;
		this.childrenCount = no_of_children;
		this.amount = amount;
	}

	public BookingDetails() {
		super();
	}

	//to string function....
	@Override
	public String toString() {
		return "_____________________________________________________\n"
				+ "Your room is booked with booking Id: "+bookingId
				+"\nBooked From: "+booked_to_String+"  Booked To: "+booked_from_String
				+"\nTotal Amount to be Paid: Rs."+amount
				+"\n_____________________________________________________";
	}
	
	public String showBooking(){
		return "_____________________________________________________\n"
				+ "Booking Id: "+bookingId
				+"\nBooked From: "+booked_to_String+"  Booked To: "+booked_from_String
				+"\nTotal Amount to be Paid: Rs."+amount
				+"\nNo Of Adults: "+adultCount+"\tNo of Children: "+childrenCount
				+"\n_____________________________________________________";
	}

	
	
	public String getBookingId() {
		return bookingId;
	}

	public String getRoomId() {
		return roomId;
	}

	public String getUserId() {
		return userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Integer getAdultCount() {
		return adultCount;
	}

	public Integer getChildrenCount() {
		return childrenCount;
	}

	public Float getAmount() {
		return amount;
	}

	public String getBooked_to_String() {
		return booked_to_String;
	}

	public String getBooked_from_String() {
		return booked_from_String;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}

	public void setChildrenCount(Integer childrenCount) {
		this.childrenCount = childrenCount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public void setBooked_to_String(String booked_to_String) {
		this.booked_to_String = booked_to_String;
	}

	public void setBooked_from_String(String booked_from_String) {
		this.booked_from_String = booked_from_String;
	}
	
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
