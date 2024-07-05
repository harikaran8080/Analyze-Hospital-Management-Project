package Hospital.HospitalManagement.entity;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="city")
@NoArgsConstructor
@AllArgsConstructor
public class City {
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID cityId;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "shortname")
	private String shortName;
	
	@Column(name = "zipcode")
	private int zipCode;
	
	

}
