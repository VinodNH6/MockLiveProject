package productRestTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import vinwork.modal.Product;

import org.json.simple.JSONObject;
import org.junit.Assert;

public class Stepdefinition {
	String apiUrl="http://localhost:8080/product";

	public Stepdefinition() {
 		RestAssured.baseURI = this.apiUrl;
	}
	    
	
    @When("^users add data on a project$")
    public void userAddsDataOnAProject() throws Exception {
    	System.out.println("ONE");
    }

    @When("^users want to get information on the (.+) project$")
    public void usersGetInformationOnAProject(String projectName) throws IOException {
    	System.out.println("TWO");
    }

    @Then("^the server should handle it and return a success status$")
    public void theServerShouldReturnASuccessStatus() {
    	System.out.println("THREE");
    	Assert.assertEquals(100, 300);
    }

    @Then("^the requested data is returned$")
    public void theRequestedDataIsReturned() {
    	System.out.println("FOUR");
    }
    
    
    
    @When("^add product with pid (.+) to a project$")
    public void oneProductAddedOnProject(int pid) throws Exception {
    	System.out.println("## ONE");
		Response response = RestAssured.given().contentType("application/json")
				.body(setRequestBody(pid).toString()).post("/add");                
		Assert.assertEquals(response.getStatusCode(), 201);
    }


    @Then("^service (.+) should have only one product$")
    public void projectShouleHaveOnlyOneProduct(String serviceUrl) {
    	System.out.println("## TWO");
		Response response = RestAssured.given().contentType("application/json").get("/"+serviceUrl);   //getall
        System.out.println(response.toString());
        List<Product> products = Arrays.asList(response.getBody().as(Product[].class));
        products.stream().map(i -> i.getName()).forEach(System.out::println);
		Assert.assertEquals(response.getStatusCode(), 200);
    }
	    
 
    @Then("^delete added product with pid (.+)$")
    public void deleteAddedProduct(int pid) {
    	System.out.println("## THREE");
		Response response = RestAssured.given().contentType("application/json").delete("/delete/"+pid);   //getall
        System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
    }
	    
	    
	private static JSONObject setRequestBody(int pid) throws Exception {
		JSONObject reqproductjson = new JSONObject();
		reqproductjson.put("pid", pid);
		reqproductjson.put("name", "cloths");
		reqproductjson.put("price", 200.00);
		reqproductjson.put("stock", 30);
		return reqproductjson;
	}
	
}