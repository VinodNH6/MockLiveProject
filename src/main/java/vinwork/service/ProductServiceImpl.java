package vinwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vinwork.dao.ProductDAO;
import vinwork.modal.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired 
	ProductDAO prodDao;
	
	public ProductServiceImpl() { }

	@Override
	public boolean save(Product product) {
		return prodDao.save(product);
	}

	@Override
	public boolean update(int pid, String newproductname) {
		return prodDao.update(pid, newproductname);
	}

	@Override
	public boolean remove(int pid) {
		return prodDao.remove(pid);
	}

	@Override
	public Product findProductById(int pid) {
		return prodDao.findProductById(pid);
	}

	@Override
	public List<Product> getAllProducts() {
		return prodDao.getAllProducts();
	}

	
}
