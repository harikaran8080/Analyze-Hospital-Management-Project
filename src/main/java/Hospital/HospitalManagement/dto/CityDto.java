package Hospital.HospitalManagement.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CityDto {
	
	private UUID cityId;
	
	private String name;
	
	private String shortName;
	
	private int zipCode;

}
