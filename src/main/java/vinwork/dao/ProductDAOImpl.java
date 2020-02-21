package vinwork.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vinwork.DB.DataBase;
import vinwork.Exceptions.UpdateFailedException;
import vinwork.modal.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	DataBase db;
	
	public ProductDAOImpl() { }

	public boolean save(Product product) {
		return db.insert(product);
	}

	public boolean update(int pid, String newproductName) {
		
		Product existingproduct = this.findProductById(pid);
		int index = db.getProducts().indexOf(existingproduct);
		
		existingproduct.setName(newproductName);
		
		boolean updatedone = false;
		try {
			db.update(index, existingproduct);
			updatedone = true;
		} catch (UpdateFailedException e) {
			e.printStackTrace();
			updatedone = false;
		}
		return updatedone;
	}

	public boolean remove(int pid) {
//		Optional<Product> productx =  db.findProductById(product.getPid());
		Optional<Product> product =  db.findProductById(pid);
		if(product.isPresent()) {
			return db.delete(product.get());
		} else {
			return false;	
		}
	}

//	public Product findProductById(int pid) {
//		return db.findProductById(pid);
//	}
	
	public Product findProductById(int pid) {
		return db.findProductById(pid).orElse(null);
	}

	public List<Product> getAllProducts() {
		return db.getProducts();
	}
	
}
