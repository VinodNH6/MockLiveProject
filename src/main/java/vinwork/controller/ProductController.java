package vinwork.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vinwork.modal.Product;
import vinwork.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService prodService;
	
	public ProductController() {}
	
	
	@RequestMapping(value = "add", 
					method = RequestMethod.POST,
					produces = "application/json", 
					consumes = "application/json")
	public ResponseEntity<Boolean> addProduct(@RequestBody Product product, @RequestHeader Map<String, String> headers) {
	    
		headers.forEach((key, value) -> {
	        System.out.println(String.format("Header '%s' = %s", key, value));
	    });
		
		Boolean savedone = prodService.save(product);
		return new ResponseEntity<Boolean>(savedone, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "get/{pid}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable int pid) {
		Product product = prodService.findProductById(pid);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	
	@RequestMapping(value = "delete/{pid}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProduct(@PathVariable int pid) {
		Boolean deletedone = prodService.remove(pid);	
		return new ResponseEntity<Boolean>(deletedone, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = prodService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
}
