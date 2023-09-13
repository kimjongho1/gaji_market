package kh.spring.gaji.interestcategory.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InterestCategoryDto {
    private int categoryId;
    private String userId;
}