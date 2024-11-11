package com.example.demo.dto;

import java.time.LocalDate;

public class DomesticDTO extends PetDTO {
private LocalDate birthDate;

public LocalDate getBirthDate() {
	return birthDate;
}

public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
}

@Override
public String toString() {
	return "DomesticDTO [birthDate=" + birthDate + ", getId()=" + getId() + ", getName()=" + getName()
			+ ", getGender()=" + getGender() + ", getPetType()=" + getPetType() + ", getOwnerDTO()=" + getOwnerDTO()
			+ "]";
}


}
