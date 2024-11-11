package com.example.demo.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.DomesticDTO;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.PetDTO;
import com.example.demo.dto.WildPetDTO;
import com.example.demo.repository.PetRepository;

import jakarta.annotation.PostConstruct;
@Repository
public class petRepositoryImpl implements PetRepository {

private List<PetDTO> petDTOList;
	

	public petRepositoryImpl() {
		this.petDTOList=new ArrayList();
}
	@PostConstruct
	public void init() {
		DomesticDTO domesticPetDTO=new DomesticDTO();
		domesticPetDTO.setId(1);
		domesticPetDTO.setName("joya");
		//domesticPetDTO.setGender(M);
		//domesticPetDTO.setPetType(DOG);
		domesticPetDTO.setBirthDate(LocalDate.of(2022,4,6));
		OwnerDTO ownerDTO =new OwnerDTO();
		ownerDTO.setId(1);
		ownerDTO.setFirstName("john");
		ownerDTO.setLastName("sen");
		//ownerDTO.setGender(M);
		ownerDTO.setCity("maihr");
		ownerDTO.setState("mp");
		ownerDTO.setMobileNumber("9111414180");
		ownerDTO.setEmailId("gp78@gmail.com");
		domesticPetDTO.setOwnerDTO(ownerDTO);
		petDTOList.add(domesticPetDTO);
		WildPetDTO wildPetDTO=new WildPetDTO();
		wildPetDTO.setId(2);
		wildPetDTO.setName("swan");
		//wildPetDTO.setGender(M);
		//wildPetDTO.setPetType(CAT);
		wildPetDTO.setBirthPlace("gir");
	    ownerDTO =new OwnerDTO();
	    ownerDTO.setId(2);
		ownerDTO.setFirstName("shey");
		ownerDTO.setLastName("sen");
		//ownerDTO.setGender(M);
		ownerDTO.setCity("jp");
		ownerDTO.setState("mp");
		ownerDTO.setMobileNumber("91188414180");
		ownerDTO.setEmailId("ss78@gmail.com");
		wildPetDTO.setOwnerDTO(ownerDTO);
		petDTOList.add(wildPetDTO);
	}

	@Override
	public Optional<PetDTO> findById(int petId) {
		
		return petDTOList.stream().filter(pet->pet.getId()==petId).findFirst();
	}

	
	

}
