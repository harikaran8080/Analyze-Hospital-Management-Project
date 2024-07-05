package Hospital.HospitalManagement.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TransactionContext {
	
	private String correlationId;
	
	private String applicationLable;
	

}
