package Hospital.HospitalManagement.controller;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hospital.HospitalManagement.entity.City;
import Hospital.HospitalManagement.response.ResponseGenerator;
import Hospital.HospitalManagement.response.TransactionContext;
import Hospital.HospitalManagement.service.CityService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/address/api")
@AllArgsConstructor
public class AddressController {
	
	private static final Logger LOGGER=java.util.logging.Logger.getLogger(ResponseGenerator.class);
	
	private @NonNull ResponseGenerator responseGenerator;
	
	private @NonNull CityService cityService;
	
	
	@ApiOperation(value = "Allows to fetch address")
	@GetMapping(value = "/getallcity")
	public ResponseEntity<?>getAllCity(@RequestHeader HttpHeaders headers) throws Exception{
		TransactionContext context=responseGenerator.generateTransactionContext(headers);
		
		try {
			List<City> cities= cityService.getAllCity();
			return responseGenerator.successGetResponse(context,"City get successfully", cities,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return responseGenerator.errorResponse(context,e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}
	
	

	

}
