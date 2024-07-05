package Hospital.HospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hospital.HospitalManagement.entity.City;
import Hospital.HospitalManagement.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;

	public List<City> getAllCity() {
		return cityRepository.findAll();
	}

}
