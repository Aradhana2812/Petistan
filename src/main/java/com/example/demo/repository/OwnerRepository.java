package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.OwnerDTO;
import com.example.demo.exception.DuplicateOwnerIdException;
import com.example.demo.exception.OwnerIdNotFoundException;

public interface OwnerRepository {
void save(OwnerDTO ownerDTO);
	
	Optional<OwnerDTO> findById(int ownerId);
	
	void updatePetDetails(int ownerId,String petName);
	
	void deleteById(int ownerId);
	
	List<OwnerDTO> findAll();
}
