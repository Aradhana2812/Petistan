package com.example.demo.dto;
/**
 * @author AradhanaChourasiya
 */
public class WildPetDTO extends PetDTO {
	private String birthPlace;

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		return "WildPetDTO [birthPlace=" + birthPlace + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getGender()=" + getGender() + ", getPetType()=" + getPetType() + ", getOwnerDTO()=" + getOwnerDTO()
				+ "]";
	}

}
