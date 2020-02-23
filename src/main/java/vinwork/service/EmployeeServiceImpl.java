package vinwork.service;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vinwork.modal.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    RestTemplate restTemplate;
    
	public EmployeeServiceImpl() {}

	@Override
	public List<Employee> getAllEmployees() {
		String url = "http://dummy.restapiexample.com/api/v1/employees";
		
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		// {
		//	"status":"success",
		//	"data":[{"id":"1","employee_name":"Tiger Nixon","employee_salary":"320800","employee_age":"61","profile_image":""}]
		// }

		List<Employee> employeeList = new ArrayList<Employee>();
		
    	JSONParser jsonParser = new JSONParser();
    	JSONObject empjobj = null;
		try {
			empjobj = (JSONObject) jsonParser.parse(result.getBody());
		} catch (ParseException e) { 
		}
		 
		JSONArray empjarr = (JSONArray) empjobj.get("data");
		for(int i=0; i<empjarr.size(); i++) {
			JSONObject jsonObj = (JSONObject) empjarr.get(i);
	
		    Employee emp = new Employee(
			    Integer.valueOf(jsonObj.get("id").toString()),
			    (String)jsonObj.get("employee_name"),
			    Integer.valueOf(jsonObj.get("employee_salary").toString()),
			    Integer.valueOf(jsonObj.get("employee_age").toString()),
			    (String)jsonObj.get("profile_image"));
			
			employeeList.add(emp);
    	}
    	 
		return employeeList;
	}

}
