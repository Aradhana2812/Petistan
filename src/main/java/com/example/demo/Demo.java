package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.PetDTO;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import com.example.demo.util.InputUtil;
@PropertySource("classpath:message.properties")
@SpringBootApplication
public class Demo implements CommandLineRunner {

	private final OwnerService ownerService;
	private final PetService petService;

	private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

//in this situation constructor based injection happening automatically we don't need to write @AutoWired
	public Demo(OwnerService ownerService, PetService petService) {
		this.ownerService = ownerService;
		this.petService = petService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
       try(Scanner scanner=new Scanner(System.in)){
    	   
    	   do {
    		   System.out.println("Welcome To Petistan");
    		   int menuOption=InputUtil.acceptMenuOption(scanner);
    		   switch(menuOption) {
    		   case 1:
    			   OwnerDTO ownerDTO =InputUtil.acceptOwnerDetailsToSave(scanner);
    			   PetDTO petDTO =InputUtil.acceptPetDetailsToSave(scanner);
    			   ownerDTO.setPetDTO(petDTO);
    			   ownerService.saveOwner(ownerDTO);
    			   System.out.println("Owner Details saved succesfully");
    			   break;
    		   case 2:
    			   int ownerId=InputUtil.acceptOwnerIdToOperate(scanner);
    			   ownerDTO=ownerService.findOwner(ownerId);
    			   System.out.println("Owner has been fetched successfully");
    			   System.out.println(ownerDTO);
    			   break;
    		   case 3:
    			 ownerId =InputUtil.acceptOwnerIdToOperate(scanner);
    			 String petName=InputUtil.acceptPetDetailsToUpdate(scanner);
    			 ownerService.updatePetDetails(ownerId,petName);
    			 System.out.println("Pet details of owner have been updated successfully");
    			 break;
    		   case 4:
    			   ownerId=InputUtil.acceptOwnerIdToOperate(scanner);
    			   ownerService.deleteOwner(ownerId);
    			   System.out.println("Owner has been deleted successfully");
    			   break;
    		   case 5:
    			   List<OwnerDTO> ownerDTOList=ownerService.findOwners();
    			   System.out.println("there are" + ownerDTOList.size() + "owners.");
    			   ownerDTOList.forEach(System.out::println);
    			   break;
    		   case 6:
    			   int petId=InputUtil.acceptPetIdToOperate(scanner);
    			   petDTO=petService.findPet(petId);
    			   System.out.println("pet has been fetched successfully");
    			   System.out.println(petDTO);
    			   break;
    			   default:
    				   System.out.println("Invalid option entered");
    				   }
    		   
    		   }while (InputUtil.wantToContinue(scanner));}
    			   
       catch(Exception exception){
    	   LOGGER.error(exception.getMessage(),exception);
       
       }
	}
}
	


