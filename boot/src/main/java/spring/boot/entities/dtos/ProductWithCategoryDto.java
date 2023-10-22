package spring.boot.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductWithCategoryDto {//data Transformation Object

	// veri transfer obje-- tek tablolarda da kullanılır 
	// tek tablo ile çalışıldığın da kulllanı
	private int productId;
	private String productName;
	private String categoryName;
}
