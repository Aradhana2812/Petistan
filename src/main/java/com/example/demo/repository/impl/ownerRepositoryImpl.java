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
import com.example.demo.repository.OwnerRepository;

import jakarta.annotation.PostConstruct;
@Repository
public class ownerRepositoryImpl implements OwnerRepository {
private List<OwnerDTO> ownerDTOList;
	

	public ownerRepositoryImpl() {
		this.ownerDTOList=new ArrayList();
}
	@PostConstruct
	public void init() {
		OwnerDTO ownerDTO =new OwnerDTO();
		ownerDTO.setId(1);
		ownerDTO.setFirstName("john");
		ownerDTO.setLastName("sen");
		//ownerDTO.setGender(M);
		ownerDTO.setCity("maihr");
		ownerDTO.setState("mp");
		ownerDTO.setMobileNumber("9111414180");
		ownerDTO.setEmailId("gp78@gmail.com");
		DomesticDTO domesticPetDTO=new DomesticDTO();
		domesticPetDTO.setId(1);
		domesticPetDTO.setName("joya");
		//domesticPetDTO.setGender(M);
		//domesticPetDTO.setPetType(DOG);
		domesticPetDTO.setBirthDate(LocalDate.of(2022,4,6));
		ownerDTO.setPetDTO(domesticPetDTO);
		ownerDTOList.add(ownerDTO);
		
		ownerDTO =new OwnerDTO();
	    ownerDTO.setId(2);
		ownerDTO.setFirstName("shey");
		ownerDTO.setLastName("sen");
		//ownerDTO.setGender(M);
		ownerDTO.setCity("jp");
		ownerDTO.setState("mp");
		ownerDTO.setMobileNumber("91188414180");
		ownerDTO.setEmailId("ss78@gmail.com");
		WildPetDTO wildPetDTO=new WildPetDTO();
		wildPetDTO.setId(2);
		wildPetDTO.setName("swan");
		//wildPetDTO.setGender(M);
		//wildPetDTO.setPetType(CAT);
		wildPetDTO.setBirthPlace("gir");
		ownerDTO.setPetDTO(wildPetDTO);
		ownerDTOList.add(ownerDTO);
		
	}
	
	@Override
	public void save(OwnerDTO ownerDTO) {
		ownerDTOList.add(ownerDTO);
		
	}
	@Override
	public Optional<OwnerDTO> findById(int ownerId) {
		
		return ownerDTOList.stream().filter(owner->owner.getId()==ownerId).findFirst();
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		ownerDTOList.stream().filter(owner->owner.getId()==ownerId).findFirst().ifPresent(ownerDTO->ownerDTO.getPetDTO().setName(petName));
	}
		
	


	@Override
	public void deleteById(int ownerId) {
		ownerDTOList.removeIf(owner->owner.getId()==ownerId);
		
	}


	@Override
	public List<OwnerDTO> findAll() {
		return ownerDTOList;
	}

	
	

}
