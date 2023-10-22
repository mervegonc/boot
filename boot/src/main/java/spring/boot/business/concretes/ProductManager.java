package spring.boot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import spring.boot.business.abstracts.ProductService;
import spring.boot.core.utilities.results.Result;
import spring.boot.core.utilities.results.ResultData;
import spring.boot.dataAccess.abstracts.ProductDao;
import spring.boot.entities.concretes.Product;
import spring.boot.entities.dtos.ProductWithCategoryDto;
import spring.boot.core.utilities.results.ResultDataSuccess;
import spring.boot.core.utilities.results.ResultSuccess;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired // tek bir instance/configure edilebilir)
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public ResultData<List<Product>> getAll() {

		return new ResultDataSuccess<List<Product>>(this.productDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new ResultSuccess("Data Added Successfuly");

	}

	@Override
	public ResultData<Product> getByProductName(String productName) {
		return new ResultDataSuccess<Product>(this.productDao.getByProductName(productName), "Data Listed");
	}

	@Override
	public ResultData<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new ResultDataSuccess<Product>(
				this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listed");
	}

	@Override
	public ResultData<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new ResultDataSuccess<List<Product>>(
				this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listed");
	}

	@Override
	public ResultData<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new ResultDataSuccess<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories),
				"Data Listed");
	}

	@Override
	public ResultData<List<Product>> getByProductNameContains(String productName) {
		return new ResultDataSuccess<List<Product>>(this.productDao.getByProductNameContains(productName),
				"Data Listed");
	}

	@Override
	public ResultData<List<Product>> getByProductNameStartsWith(String productName) {
		return new ResultDataSuccess<List<Product>>(this.productDao.getByProductNameStartsWith(productName),
				"Data Listed");
	}

	@Override
	public ResultData<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		return new ResultDataSuccess<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),
				"Data Listed");
	}

	@Override
	public ResultData<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new ResultDataSuccess<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public ResultData<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new ResultDataSuccess<List<Product>>(this.productDao.findAll(sort), "Successfull");
	}

	@Override
	public ResultData<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new ResultDataSuccess<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),
				"Data Listed");
	}

}
