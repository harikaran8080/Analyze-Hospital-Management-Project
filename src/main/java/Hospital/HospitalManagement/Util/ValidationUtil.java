package Hospital.HospitalManagement.Util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtil {
	
	private ValidationUtil() {
		
	}
	
	public static boolean isNullOrEmpty(String value) {
		return null == value || value.trim().isEmpty();
	
	}
	
	public static boolean isNull(Double value) {
		return null == value || value == 0;
	}
	
	public static boolean isNull(UUID value) {
		return null == value;
	}
	
	public static boolean isNull(Integer value) {
		return null == value || value ==0;	
	}
	
	public static boolean isNullObject(Object value) {
		return null == value;
	}
	
	public static boolean isNull(byte[] value) {
		return null == value || value.toString().trim().isEmpty();
	}
	
	public static boolean isValidPinCode(Long value) {
		String regex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
		Pattern p = Pattern.compile(regex);
		String s = String.valueOf(value);
		Matcher m =p.matcher(s);
		return m.matches();
		
				
	}
	
	public static boolean isValidMobileNumber(String value) {
		String regex = "(?:\\s+|)((0|(?:(\\+|)91))(?:\\s|-)*(?:(?:\\d(?:\\s|-)*\\d{2}(?:\\s|-)*\\d{8})|(?:\\d{3}(?:\\s|-)*\\d{7}))|\\d{10})(?:\\s+|)";
		Pattern p = Pattern.compile(regex);
		String s = String.valueOf(value);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	
	public static boolean isValidPhoneNo(String phoneNo) {
		if(phoneNo.length() < 10 || phoneNo.length() > 10) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidEmailId(String value) {
		String regex = "^(?=.{1,64}@)[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9-.]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	public static boolean isValidName(String value) {
		String regex = "^(?=.{1,40}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$";
		Pattern p =Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	
}
