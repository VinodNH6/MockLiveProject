package vinwork.dao;

import java.util.List;

import vinwork.modal.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(int pid, String newproductname);
	public boolean remove(int pid);
	public Product findProductById(int pid);
	public List<Product> getAllProducts();
}
