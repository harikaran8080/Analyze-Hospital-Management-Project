package Hospital.HospitalManagement.validator;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controlleradvice.ObjectInvalidException;
import com.app.dto.AttachmentDTO;
import com.app.entity.Doctor;
import com.app.util.PasswordUtil;

import Hospital.HospitalManagement.Util.ValidationUtil;
import Hospital.HospitalManagement.dto.DoctorDTO;
import Hospital.HospitalManagement.entity.Attachment;
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
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getAge())) {
				errors.add(messegePropertyService.getMessege("doctor.age.required"));
			}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getFirstName())) {
				errors.add(messegePropertyService.getMessege("doctor.first.name.required"));
				}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getLastName())) {
				errors.add(messegePropertyService.getMessege("doctor.last.name.required"));
			}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getDepartment())) {
				errors.add(messegePropertyService.getMessege("department.required"));
			}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getGender())) {
				errors.add(messegePropertyService.getMessege("doctor.gender.required"));
			}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getEmail())) {
				errors.add(messegePropertyService.getMessege("email.required"));
			}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getPassword())){
				errors.add(messegePropertyService.getMessege("password.required"));
			}
			if(ValidationUtil.isNullOrEmpty(doctorDTO.getPhoneNo())) {
				errors.add(messegePropertyService.getMessege("phone.no.required"));
			}
			else {
				if(ValidationUtil.isNull(doctorDTO.getDoctorId())) {
					throw new ObjectInvalidException(messegePropertyService.getMessege("invalid.request.payload"));
				}
				Optional<Doctor> doctorOptional = doctorRepository.findById(doctorDTO.getDoctorId());
				
				if(!doctorOptional.isPresent()) {
					throw new ObjectInvalidException(messegePropertyService.getMessege("doctor.not.found"));
				}
				doctor= doctorOptional.get();
			}
			
			ValidationResult result= new ValidationResult();
//			
//			Attachment uploadImageObj = uploadImageList(doctorDTO.getUploadImage());
//			Attachment uploadCertificateObj = uploadCertificateList(doctorDTO.getUploadCertifigate());
			
			if(errors.size()>0) {
				String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
				throw new ObjectInvalidException(errorMessage);
			}
			if(null == doctor) {
				doctor = Doctor.builder().firstName(doctorDTO.getFirstName()).lastName(doctorDTO.getLastName())
						.email(doctorDTO.getEmail()).password(PasswordUtil.getEncryptedPassword(doctorDTO.getPassword()))
						.phoneNo(doctorDTO.getPhoneNo()).department(doctorDTO.getDepartment())
						.gender(doctorDTO.getGender()).age(doctorDTO.getAge())
						.build();
			}
			else {
				doctor.setFirstName(doctorDTO.getFirstName());
				doctor.setLastName(doctorDTO.getLastName());
				doctor.setDepartment(doctorDTO.getDepartment());
				doctor.setEmail(doctorDTO.getEmail());
//				doctor.setPassword(doctorDTO.getPassword());
				doctor.setPhoneNo(doctorDTO.getPhoneNo());
				doctor.setGender(doctorDTO.getGender());
				doctor.setAge(doctorDTO.getAge());
				
			}
			result.setObject(doctor);
			return result;
		
		}
	}

//	private Attachment uploadCertificateList(AttachmentDTO uploadCertifigate) {
//		return null;
//	}
//
//	private Attachment uploadImageList(AttachmentDTO uploadImage) {
//		return null;
//	}

}
