package Hospital.HospitalManagement.validator;

import java.util.List;

import lombok.Data;

@Data
public class ValidationResult {
	private boolean isValid = true;
	
	private List<String> errors;
	
	private Object object;

}
