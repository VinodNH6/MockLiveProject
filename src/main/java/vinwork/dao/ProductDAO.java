package vinwork.dao;

import java.util.List;

import vinwork.modal.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(int pid, String newproductname);
	public boolean remove(Product product);
	public Product findProductById(int pid);
	public List<Product> getAllProducts();
}
