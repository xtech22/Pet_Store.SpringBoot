package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.model.PetStoreData;
import pet.store.service.PetStoreService;


@ComponentScan
@RestController 				//handles RESTful API requests
@RequestMapping("/pet_store") 	//specifies the base URL
@Slf4j 							//used for logging 
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService;

//	@RequestBody indicates that the PetStoreData object will be passed in the request body.

	@PostMapping("/pet_store") 														//handles HTTP POST requests to the "/pet_store" endpoint.
	@ResponseStatus(code = HttpStatus.CREATED) 										//sets the HTTP response status code to 201
	public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) { 	//This method creates a new pet store by saving the provided petStoreData using the petStoreService, and returns the saved data.
		log.info("Saving pet store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}
	
	
	

//	This method updates an existing pet store with the specified ID by setting the ID on the provided petStoreData object and saving it using the petStoreService. 
	@PutMapping("/pet_store/{petStoreId}") 								//handles HTTP PUT requests to the "/pet_store/{petStoreId}" endpoint.
	public PetStoreData updatePetStore(@PathVariable Long petStoreId, 	//the petStoreId value will be extracted from the URL path.
			@RequestBody PetStoreData petStoreData) {
		log.info("Updating pet store  with ID=" + petStoreId);
		petStoreData.setPetStoreId(petStoreId);
		
		return petStoreService.savePetStore(petStoreData); 				//Updated data returned 
	}
}