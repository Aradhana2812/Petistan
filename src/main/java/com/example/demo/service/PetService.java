package com.example.demo.service;

import com.example.demo.dto.PetDTO;
import com.example.demo.exception.PetNotFoundException;

public interface PetService {
	PetDTO findPet(int peTId) throws PetNotFoundException;
}
