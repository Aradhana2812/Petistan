package com.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import com.example.demo.dto.DomesticDTO;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.PetDTO;
import com.example.demo.dto.WildPetDTO;
import com.example.demo.enums.Gender;
import com.example.demo.enums.PetType;

public class InputUtil {
	//so that no one can create the object of InputUtil
	private InputUtil(){
		
	}
public static int acceptMenuOption(Scanner scanner) {
	System.out.println("press 1 to add new Owner");
	System.out.println("press 2 to fetch Owner Details");
	System.out.println("press 3 to update pet details of owner");
	System.out.println("press 4 to delete owner details");
	System.out.println("press 5 to fetch all owners");
	System.out.println("press 6 to fetch pet details");
	 int menuOption=scanner.nextInt();
	 if(menuOption==1 || menuOption==2 || menuOption==3 || menuOption==4 || menuOption==5 || menuOption==6) {
		 return menuOption;
	 }else 
	 {
		 System.out.println("invalid expression entered");
		 return acceptMenuOption(scanner);
	 }
}
public static boolean wantToContinue(Scanner scanner) {
	System.out.println("press Y to continue or press N to exit");
	char choice =scanner.next().toUpperCase().charAt(0);
	return 'Y'==choice;
	
}
public static OwnerDTO acceptOwnerDetailsToSave(Scanner scanner) {
	System.out.println("Enter the id of owner");
	int id =scanner.nextInt();
	System.out.println("Enter the first name of owner");
	String firstName=scanner.next();
	System.out.println("Enter the last name of owner");
	String lastName=scanner.next();
	System.out.println("enter the gender of owner:"+ Arrays.asList(Gender.values().toString()));
	String gender =scanner.next().toUpperCase();
	System.out.println("Enter city of Owner");
	String city=scanner.next();
	System.out.println("enter the state of owner");
	String state=scanner.next();
	System.out.println("Enter the mobile number of owner");
	String mobileNumber=scanner.next();
	System.out.println("Enter the Email Id of owner");
	String emailId=scanner.next();
	try {
		OwnerDTO ownerDTO=new OwnerDTO();
		ownerDTO.setId(id);
		ownerDTO.setFirstName(firstName);
		ownerDTO.setLastName(lastName);
		ownerDTO.setGender(Gender.valueOf(gender));
		ownerDTO.setCity(city);
		ownerDTO.setState(state);
		ownerDTO.setMobileNumber(mobileNumber);
		ownerDTO.setEmailId(emailId);
		return ownerDTO;
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return acceptOwnerDetailsToSave(scanner);
	}
}
public static PetDTO acceptPetDetailsToSave(Scanner scanner) {
	System.out.println("Enter the id of pet");
	int petId=scanner.nextInt();
	System.out.println("Enter the name of pet");
	String petName=scanner.next();
	System.out.println("Press D for domestic animal and press W for Wild animal");
	char choice=scanner.next().toUpperCase().charAt(0);
	String petPlaceOfBirth=null;
	String petDateOfBirth=null;
	if('W'==choice) {
		System.out.println("enter the birth place of pet");
		petPlaceOfBirth=scanner.next();
	}else if('D'==choice) {
		System.out.println("Enter the birth date of pet(dd-mm-yyyy):");
		petDateOfBirth=scanner.next();
	}
	System.out.println("enter the gender of pet:" + Arrays.asList(Gender.values().toString()));
	String petGender=scanner.next().toUpperCase();
	System.out.println("Enter the pet type:" + Arrays.asList(PetType.values().toString()));
	String petType=scanner.next().toUpperCase();
	try {
		PetDTO petDTO=null;
		if('D'==choice) {
			petDTO=new DomesticDTO();
			((DomesticDTO)petDTO).setBirthDate(convertStringToDate(petDateOfBirth));
		}else if('W'==choice)
		{
			petDTO=new WildPetDTO();
			((WildPetDTO)petDTO).setBirthPlace(petPlaceOfBirth);
		}else {
			throw new IllegalArgumentException("Unsupported pet choice:" +choice);
		}
		petDTO.setId(petId);
		petDTO.setName(petName);
		petDTO.setGender(Gender.valueOf(petGender));
		petDTO.setPetType(PetType.valueOf(petType));
		
		return petDTO;
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return acceptPetDetailsToSave( scanner);
	}
}
	public static String acceptPetDetailsToUpdate(Scanner scanner) {
		System.out.println("Enter updated name of pet");
		return scanner.next();
		
	}
	public static int acceptOwnerIdToUpdate(Scanner scanner) {
		System.out.println("Enter id of Owner");
		return scanner.nextInt();
	}
	public static int acceptPetIdToUpdate(Scanner scanner) {
		System.out.println("Enter the id of pet");
		return scanner.nextInt();
	}

private static LocalDate convertStringToDate(String stringDate) {
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-mm-yyyy");
	return LocalDate.parse(stringDate,format);
	
}
public static int acceptOwnerIdToOperate(Scanner scanner) {
	
	System.out.println("Enter the id of owner");
	return scanner.nextInt();
}
public static int acceptPetIdToOperate(Scanner scanner) {
	
	System.out.println("Enter the id of pet");
	return scanner.nextInt();
}

}




