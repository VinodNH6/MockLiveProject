package vinwork.service;

import java.util.List;

import vinwork.modal.Product;

public interface ProductService {
	public boolean save(Product product);
	public boolean update(int pid, String newproductname);
	public boolean remove(int pid);
	public Product findProductById(int pid);
	public List<Product> getAllProducts();
	
}
