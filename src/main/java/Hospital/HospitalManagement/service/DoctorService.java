package Hospital.HospitalManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hospital.HospitalManagement.entity.Doctor;
import Hospital.HospitalManagement.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public Optional<Doctor> getByPhoneNo(String phoneNo) {
		return doctorRepository.findByPhoneNo(phoneNo);
	}

}
