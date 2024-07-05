package Hospital.HospitalManagement.validator;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.food.delivery.controlleradvice.ObjectInvalidException;

import Hospital.HospitalManagement.Util.ValidationUtil;
import Hospital.HospitalManagement.dto.DoctorDTO;
import Hospital.HospitalManagement.entity.Doctor;
import Hospital.HospitalManagement.enumeration.RequestType;
import Hospital.HospitalManagement.repository.DoctorRepository;
import Hospital.HospitalManagement.service.DoctorService;
import Hospital.HospitalManagement.service.MessegePropertyService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorValidator {
	
	@Autowired
	private MessegePropertyService messegePropertyService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	List<String>errors = null;
	List<String>errorsObj=null;
	List<String>subject=null;
	
	public ValidationResult validate(RequestType Type,DoctorDTO doctorDTO)throws Exception{
		errors = new ArrayList<String>();
		
		Doctor doctor=null;
		
		if(Type.equals(RequestType.POST)) {
			
			if(!ValidationUtil.isNull(doctorDTO.getDoctorId())) {
				throw new ObjectInvalidException(messegePropertyService.getMessege("invalid.request.payload"));
			}
			Optional<Doctor>optional=doctorService.getByPhoneNo(doctorDTO.getPhoneNo());
			if(optional.isPresent()) {
				String[] params = new String[] {doctorDTO.getPhoneNo()};
				errors.add(messegePropertyService.getMessege("doctor.phone.no.duplicate",params));
				
			}
		}
	}

}
