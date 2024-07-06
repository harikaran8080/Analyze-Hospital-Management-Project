package Hospital.HospitalManagement.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.config.WriteableRepository;

import Hospital.HospitalManagement.entity.Doctor;

@Repository
public interface DoctorRepository extends WriteableRepository<Doctor, UUID>{

	@Query("select d form doctor d where d.phone_n=:phoneNo")
	Optional<Doctor> findByPhoneNo(String phoneNo);



}
