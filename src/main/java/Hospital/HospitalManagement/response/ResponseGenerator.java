package Hospital.HospitalManagement.response;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;



@Component
public class ResponseGenerator {

	private static final Logger LOGGER=Logger.getLogger(ResponseGenerator.class);
	
	
	
	
	public TransactionContext generateTransactionContext(HttpHeaders headers) {
		TransactionContext context=new TransactionContext();
		
		if(headers == null) {
			context.setCorrelationId("demo");
			context.setApplicationLable("demo");
		}
		if(headers.get("correlationId") != null) {
			context.setCorrelationId(headers.get("correlationId").toString());
		}else {
			context.setCorrelationId("demo");
		}
		if(headers.get("applicationLable") != null) {
			context.setApplicationLable(headers.get("applicationLable").toString());
		}else {
			context.setApplicationLable("demo");
		}
		return context;
	}
	
	public ResponseEntity<Response>successGetResponse(TransactionContext context,String message,Object object,HttpStatus httpStatus){
		HttpHeaders headers=new HttpHeaders();
		headers.add("correlationId", context.getCorrelationId());
		headers.add("applicationLable", context.getApplicationLable());
		headers.add("Content-Type","application/json");
		Response response=new Response();
		response.setData(object);
		response.setMessage(message);
		response.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		LOGGER.debug("response class is " + Data.class);
		LOGGER.debug("response status is "+httpStatus.toString());
		ResponseEntity<Response>responseEntity=new ResponseEntity<Response>(response,headers,httpStatus);
		return responseEntity;
		
		
	}
	
	public ResponseEntity<Response>errorResponse(TransactionContext context,String erorrMessage,HttpStatus httpStatus){
		HttpHeaders headers=new HttpHeaders();
		headers.add("correlationId",context.getCorrelationId());
		headers.add("applicationLable",context.getApplicationLable());
		headers.add("Content-Type","application/json");
		Erorr erorr=new Erorr();
		erorr.setCode(httpStatus.toString());
		erorr.setReason(erorrMessage);
		Response response=new Response();
		response.setError(erorr);
		response.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		ResponseEntity<Response>responseEntity=new ResponseEntity<Response>(response,headers,httpStatus);
		return responseEntity;
		
	}
}
