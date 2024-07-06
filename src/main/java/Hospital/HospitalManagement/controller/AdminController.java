package Hospital.HospitalManagement.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hospital.HospitalManagement.dto.DoctorDTO;
import Hospital.HospitalManagement.entity.Doctor;
import Hospital.HospitalManagement.enumeration.RequestType;
import Hospital.HospitalManagement.response.ResponseGenerator;
import Hospital.HospitalManagement.response.TransactionContext;
import Hospital.HospitalManagement.service.DoctorService;
import Hospital.HospitalManagement.validator.DoctorValidator;
import Hospital.HospitalManagement.validator.ValidationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/admincontroller/api")
@Api(value = "AdminController Rest API")
public class AdminController {
	
	private static final Logger LOGGER=Logger.getLogger(AdminController.class);
	
	private @NonNull ResponseGenerator generator;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorValidator doctorValidator;
	
	@ApiOperation(value = "Allows to create Admin Controller")
	@PostMapping(value = "/create",produces = "application/json")
	public ResponseEntity<?>create(@ApiParam(value = "The Admin Controller request payload")@RequestBody DoctorDTO doctordto,
			@RequestHeader HttpHeaders headers)throws Exception{
		
		
		TransactionContext context= generator.generateTransactionContext(headers);
		
		ValidationResult result=doctorValidator.validate(RequestType.POST, doctordto);
		
		try {
			doctorService.getByPhoneNo((Doctor)(ValidationResult.get))
		}
	}
	
	

}
