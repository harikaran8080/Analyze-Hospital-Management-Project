package Hospital.HospitalManagement.entity;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID doctorId;
	
	
	@Column(name = "doctor_no")
	private String doctorNo;
	
	@NotBlank(message = "password cannot be blank")
	@Column(name ="password")
	private String password;
	
	@NotBlank(message = "firstname cannot be blank")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "lastname cannot be blank")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Email cannot be blank")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "department cannot be blank")
	@Column(name = "department")
	private String department;
	
	@NotBlank(message = "Mobile no cannot be blank")
	@Column(name = "phone_no")
	private String phoneNo;
	
	@NotBlank(message = "gender cannot be blank")
	@Column(name = "gender")
	private String gender;
	
	@NotBlank(message = "age cannot be blank")
	@Column(name = "age")
	private String age;

}
