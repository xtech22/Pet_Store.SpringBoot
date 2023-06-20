package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity 				//indicates that this is a persistent entity in a database
@Data					//generates boilerplate code for getters, setters, equals, hashCode, and toString methods.
public class Customer {
	
	@Id 													//indicates primary key for the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//specifying that the value of the identifier will be generated automatically.
	private Long customerId;								//represents the unique identifier for the customer
	
	
	// different columns that will be added to the "customer" table with their respected data types.
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	
	
	
	
	// The code snippet defines a field named "petStores" in a class, which represents
	// the set of pet stores associated with an entity.


	// The "cascade = CascadeType.PERSIST" configuration specifies that when a new pet store
	// is added to the set, it should be persisted in the database.
	
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST) //specifies that the "customers" field is owning side of the relationship.
	private Set<PetStore> petStores = new HashSet<>();
}
