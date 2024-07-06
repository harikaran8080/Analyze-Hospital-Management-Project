package Hospital.HospitalManagement.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Builder
@Entity
@Data
@Table(name ="attachment")
public class Attachment {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID AttchId;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "reference_id")
	private UUID referencId;
	
	@Column(name ="orginal_file_name")
	private String orginalFileName;
	
	@Column(name ="file_size")
	private long fileSize;
	
	
	
	

}
