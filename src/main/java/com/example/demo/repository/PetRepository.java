package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.PetDTO;
import com.example.demo.exception.DuplicateOwnerIdException;
import com.example.demo.exception.OwnerIdNotFoundException;

public interface PetRepository {
    
	
	Optional<PetDTO> findById(int petId);
	
	}
