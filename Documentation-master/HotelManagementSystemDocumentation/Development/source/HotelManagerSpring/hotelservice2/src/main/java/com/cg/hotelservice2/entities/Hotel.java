package com.cg.hotelservice2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {

	@Id
	@Column(name="hotel_id")
	private String hotelId; //hotel_id
	
	@Column(name="city")
	private String city;  //city
	@Column(name="hotel_name")
	private String hotelName; //hotel_name
	@Column(name="address")
	private String address; //address
	@Column(name="description")
	private String description; //description
	@Column(name="avg_rate_per_night")
	private float avgRatePerNight; //avg_rate_per_night
	@Column(name="phone_no1")
	private String phoneNo; //phone_no
	@Column(name="phone_no2")
	private String phoneNo2; //phone_no2
	@Column(name="rating")
	private String rating; //rating
	@Column(name="email")
	private String email; //email
	@Column(name="fax")
	private String fax; //fax
	
	

	public Hotel(String hotelId, String city, String hotelName, String address,
			String description, float avgRatePerNight, String phoneNo,
			String phoneNo2, String rating, String email, String fax) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo = phoneNo;
		this.phoneNo2 = phoneNo2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}

	public Hotel() {
		super();
	}

	//to string function....
	@Override
	public String toString() {
		
		
		
		
		
		return  "________________________________________________________________________________"
				+ "\nHotel Id: "+hotelId+"  Hotel Name: "+hotelName.toUpperCase()
				+ "\nAddress: "+address+"\t City: "+city
				+ "\nDescription:\n"+description
				+ "\nRating: "+rating+ " Star"+"\n"+phoneNo+"\t|\t"+phoneNo2
				+ "\nEmail: "+email+"\tFax: "+fax+"\n"
				+ "________________________________________________________________________________";
		 
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(float avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	
	
	
}
