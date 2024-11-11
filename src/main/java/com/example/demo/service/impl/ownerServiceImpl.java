package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OwnerDTO;
import com.example.demo.exception.DuplicateOwnerIdException;
import com.example.demo.exception.OwnerIdNotFoundException;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.service.OwnerService;
@Service
public class ownerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private final String ownerAlreadyExist;
	private final String ownerNotFound;
	
	public ownerServiceImpl(OwnerRepository ownerRepository,@Value("${owner.already.exist}")String ownerAlreadyExist, @Value("${owner.not.found}")String ownerNotFound) {
		
		this.ownerRepository = ownerRepository;
		this.ownerAlreadyExist=ownerAlreadyExist;
		this.ownerNotFound = ownerNotFound;
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException {
		if(ownerRepository.findById(ownerDTO.getId()).isPresent()) {
			throw new DuplicateOwnerIdException(String.format(ownerAlreadyExist,ownerDTO.getId()));
		}else ownerRepository.save(ownerDTO);
		
	}
	
	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerIdNotFoundException {
		
		return ownerRepository.findById(ownerId).orElseThrow(()->new OwnerIdNotFoundException(String.format(ownerNotFound,ownerId)));
	}

	

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerIdNotFoundException {
		ownerRepository.findById(ownerId).orElseThrow(()->new OwnerIdNotFoundException(String.format(ownerNotFound,ownerId)));
		ownerRepository.updatePetDetails(ownerId,petName);
		
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerIdNotFoundException {
		ownerRepository.findById(ownerId).orElseThrow(()->new OwnerIdNotFoundException(String.format(ownerNotFound,ownerId)));
		ownerRepository.deleteById(ownerId);
		
	}

	@Override
	public List<OwnerDTO> findOwners() {
		return ownerRepository.findAll();
	}

}
