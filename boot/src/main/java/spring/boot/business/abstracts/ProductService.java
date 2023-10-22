package spring.boot.business.abstracts;

import java.util.List;

import spring.boot.core.utilities.results.Result;
import spring.boot.core.utilities.results.ResultData;
import spring.boot.entities.concretes.Product;
import spring.boot.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	ResultData<List<Product>> getAll();

	Result add(Product product);
	
	ResultData<List<Product>> getAll(int pageNo, int pageSize);
	
	ResultData<List<Product>> getAllSorted();
	
	

	ResultData<Product> getByProductName(String productName);

	ResultData<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	ResultData<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	ResultData<List<Product>> getByCategoryIdIn(List<Integer> categories);

	ResultData<List<Product>> getByProductNameContains(String productName);

	ResultData<List<Product>> getByProductNameStartsWith(String productName);

	ResultData<List<Product>> getByNameAndCategoryId(String productName, int categoryId);
	
	ResultData<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	// sayfalamak
	
	
}
