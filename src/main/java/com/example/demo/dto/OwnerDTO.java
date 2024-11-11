package com.example.demo.dto;

import com.example.demo.enums.Gender;
/**
 * @author AradhanaChourasiya
 */
public class OwnerDTO {
	private int id;
	private String firstName;
	private String LastName;
	private Gender gender;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailId;
	private PetDTO petDTO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public PetDTO getPetDTO() {
		return petDTO;
	}

	public void setPetDTO(PetDTO petDTO) {
		this.petDTO = petDTO;
	}

	@Override
	public String toString() {
		return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", gender=" + gender
				+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", petDTO=" + petDTO + "]";
	}

}
