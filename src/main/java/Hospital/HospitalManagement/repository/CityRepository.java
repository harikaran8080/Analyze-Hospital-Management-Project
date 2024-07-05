package Hospital.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Hospital.HospitalManagement.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}