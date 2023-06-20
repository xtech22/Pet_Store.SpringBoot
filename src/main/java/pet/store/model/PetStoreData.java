package pet.store.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
//	These lines define instance variables for storing pet store data.
//	The variables store information such as the ID, name, city, state, ZIP code, and phone number of the pet store.
//	There are also two sets (customers and employees) that store instances of PetStoreCustomer and PetStoreEmployee classes.
	private Long petStoreId;
	private String petStoreName;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();
	
	
//	This is a constructor for PetStoreData that takes a PetStore object as input.
//	It extracts data from the petStore object and initializes the corresponding fields in the PetStoreData instance.
	public PetStoreData(PetStore petStore) {
		this.petStoreId = petStore.getPetStoreId();
		this.petStoreName = petStore.getPetStoreName();
		this.petStoreCity = petStore.getPetStoreCity();
		this.petStoreState = petStore.getPetStoreState();
		this.petStoreZip = petStore. getPetStoreZip();
		this.petStorePhone = petStore.getPetStorePhone();

		for(Customer customer : petStore.getCustomers()) {
			this.customers.add(new PetStoreCustomer(customer));
		}
		for(Employee employee : petStore.getEmployees()) {
			this.employees.add(new PetStoreEmployee(employee));
		}
	}

	@Data
	@NoArgsConstructor									//takes an Employee object as input.
	public static class PetStoreCustomer { 				//a Customer object as input.
 
		public PetStoreCustomer(Customer customer) {	//initializes and "Gets" the corresponding fields in the PetStoreCustomer instance.
			customerId = customer.getCustomerId();
			customerFirstName = customer.getCustomerFirstName();
			customerLastName = customer.getCustomerLastName();
			customerEmail = customer.getCustomerEmail();

		}

		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;

	}


	@Data
	@NoArgsConstructor 									//takes an Employee object as input.
	public static class PetStoreEmployee {

		public PetStoreEmployee(Employee employee) { 	//initializes and "Gets" the corresponding fields in the PetStoreEmployee instance.
			employeeId = employee.getEmployeeId();
			employeeFirstName = employee.getEmployeeFirstName();
			employeeLastName = employee.getEmployeeLastName();
			employeePhone = employee.getEmployeePhone();
			employeeJobTitle = employee.getEmployeeJobTitle();
		}

		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeePhone;
		private String employeeJobTitle;
	}

}






































































