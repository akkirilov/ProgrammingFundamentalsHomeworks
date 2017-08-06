package app.models.categoriesDto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesDto {
	
	@XmlElement(name = "category")
	private List<CategoryDto> categoryDtos;
	
	@XmlElement(name = "category")
	private List<CategoryWithProductsDto> categoryWithProductsDto;

	public CategoriesDto() {
		super();
	}

	public List<CategoryDto> getCategoryDtos() {
		return categoryDtos;
	}

	public void setCategoryDtos(List<CategoryDto> categoryDtos) {
		this.categoryDtos = categoryDtos;
	}

	public List<CategoryWithProductsDto> getCategoryWithProductsDto() {
		return categoryWithProductsDto;
	}

	public void setCategoryWithProductsDto(List<CategoryWithProductsDto> categoryWithProductsDto) {
		this.categoryWithProductsDto = categoryWithProductsDto;
	}

}
