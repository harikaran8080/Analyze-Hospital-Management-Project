package Hospital.HospitalManagement.dto;

import java.util.UUID;

import com.app.dto.AttachmentDTO;

import Hospital.HospitalManagement.entity.Attachment;
import lombok.Data;

@Data
public class DoctorDTO {
	
    private UUID doctorId;
	
	
	private String doctorNo;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String department;
	
	private String phoneNo;
	
	private String gender;
	
	private String age;

	AttachmentDTO UploadImage ;

	AttachmentDTO UploadCertifigate;
	
	

}
