package kh.spring.gaji.category.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CategoryDto {
	private int categoryId;
    private String categoryName;
}
