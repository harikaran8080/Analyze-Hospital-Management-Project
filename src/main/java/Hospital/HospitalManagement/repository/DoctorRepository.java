package Hospital.HospitalManagement.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Hospital.HospitalManagement.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	@Query("select d form doctor d where d.phone_n=:phoneNo")
	Optional<Doctor> findByPhoneNo(String phoneNo);

}
