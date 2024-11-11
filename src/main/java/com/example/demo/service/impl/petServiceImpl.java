package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PetDTO;
import com.example.demo.exception.PetNotFoundException;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
@Service
public class petServiceImpl implements PetService {
	PetRepository petRepository;
	final String petNotFound;
	//
	public petServiceImpl(PetRepository petRepository, @Value("${pet.not.found}")String petNotFound) {
		
		this.petRepository = petRepository;
		this.petNotFound = petNotFound;
	}

	@Override
	public PetDTO findPet(int petId) throws PetNotFoundException {
		
		return petRepository.findById(petId).orElseThrow(()->new PetNotFoundException(String.format(petNotFound,petId)));
	}

}
