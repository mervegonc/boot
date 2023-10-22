package spring.boot.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import spring.boot.business.abstracts.ProductService;
import spring.boot.entities.concretes.Product;
import spring.boot.entities.dtos.ProductWithCategoryDto;
import spring.boot.core.utilities.results.Result;
import spring.boot.core.utilities.results.ResultData;

@RestController//dfd
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")
	public ResultData<List<Product>> getAll() {// veriyi bana ver-veriyi değiştir = http istekleri/http requests =
												// @GetMapping
		return (this.productService.getAll());
	}

	@PostMapping("/add") // post mapping de eğer parametre alınırsa @RequestBody alınır mesaj gövdesine
							// bilgileri jason datasına dönüştürüp gönder
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);

	}

	@GetMapping("/getByProductName")
	public ResultData<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public ResultData<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameContains")
	public ResultData<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("/getAllByPage")
	public ResultData<List<Product>> getAll(int pagNo, int pageSize) {
		return this.productService.getAll(pagNo, pageSize);
	}
	
	@GetMapping("/getAllSorted")
	public ResultData<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public ResultData<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}

}
