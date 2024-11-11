package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OwnerDTO;
import com.example.demo.exception.DuplicateOwnerIdException;
import com.example.demo.exception.OwnerIdNotFoundException;
/**
 * @author AradhanaChourasiya
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;
	
	OwnerDTO findOwner(int ownerId) throws OwnerIdNotFoundException;
	
	void updatePetDetails(int ownerId,String petName) throws OwnerIdNotFoundException;
	
	void deleteOwner(int ownerId) throws OwnerIdNotFoundException;
	
	List<OwnerDTO> findOwners();

}
