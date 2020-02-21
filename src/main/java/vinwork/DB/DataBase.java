package vinwork.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import vinwork.Exceptions.UpdateFailedException;
import vinwork.modal.Product;

@Component
public class DataBase {

	List<Product> products = null;
	
	public DataBase() {
		products = new ArrayList<Product>();
	}

	public boolean insert(Product product) {
		return products.add(product);
	}
	
	public void update(int index, Product updatedproduct) throws UpdateFailedException{
		try {
			products.set(index, updatedproduct);
		} catch(Exception e) {
			throw new UpdateFailedException("Product update failed. Try again");
		}
	}
	
	public boolean delete(Product product) {
		return products.remove(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
//	public Product findProductById(int pid) {
//		return products.stream()
//				.filter(product -> product.getPid() == pid)
//				.findAny()
//				.orElse(null);
//	}
	
	public Optional<Product> findProductById(int pid) {
		return products.stream()
				.filter(product -> product.getPid() == pid)
				.findAny();
	}
	
}
