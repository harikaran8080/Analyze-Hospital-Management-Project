package Hospital.HospitalManagement.service;

import org.codehaus.groovy.tools.shell.util.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessegePropertyService {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessege(String key) {
		return messageSource.getMessage(key);
	}
	
	public String getMessege(String key,String[] params) {
		return messageSource.getMessage(key);
	}
	
	

}
