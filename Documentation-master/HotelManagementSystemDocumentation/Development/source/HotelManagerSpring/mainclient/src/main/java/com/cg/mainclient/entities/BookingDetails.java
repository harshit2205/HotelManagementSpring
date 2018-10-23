package com.cg.mainclient.entities;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



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
	private String booked_to_String;
	private String booked_from_String;
	
	
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", roomId=" + roomId
				+ ", userId=" + userId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", adultCount=" + adultCount
				+ ", childrenCount=" + childrenCount + ", amount=" + amount
				+ ", booked_to_String=" + booked_to_String
				+ ", booked_from_String=" + booked_from_String + "]";
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	
	public void setstartDate(){
		try {
			this.startDate = convertUtilToSql(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(booked_from_String));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void setendDate(){
		try {
			this.endDate = convertUtilToSql(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(booked_to_String));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
	
	

}
