package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity 			//indicating that it is a persistent entity in a database.
@Data				//generates boilerplate code for getters, setters, equals, hashCode, and toString methods.
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;
	
	// The code snippet defines a field named "petStore" in a class, which represents
	// a single pet store associated with an entity.

	// The "cascade = CascadeType.ALL" configuration specifies that any changes made to the
	// associated pet store should be cascaded to this entity.

	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_store_id") 		//specifies the mapping of the foreign key column between this entity and the "PetStore" entity
	private PetStore petStore;
	
	
}
