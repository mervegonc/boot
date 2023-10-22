package spring.boot.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.boot.entities.concretes.Product;
import spring.boot.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {// crud yapmamızı sağlayacak
	// JOİN
	// biz buradan sorgu atıp bu sorgu sonucu kolonları ve isteklerimii çekiyoruz
	// Query yi operasyon haline getiriyoruz
	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

	List<Product> getByProductNameStartsWith(String productName);

	List<Product> getByProductNameContains(String productName);

	// JPQUER
	@Query("From Product where productName =: productName and category.categoryId =: categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

	
	@Query("Select new spring.boot.entities.dtos.ProductWithCategoryDto" 
	+ "(p.productId, p.productName, c.categoryName)"
			+ "From  Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	/*
	 * select p.product_id, p.product_name, c.category_name 
	 * from products p inner join categories c 
	 * on p.category_id = c.category_id
	 */

}
