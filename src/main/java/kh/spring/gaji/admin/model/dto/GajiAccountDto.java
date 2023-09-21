package kh.spring.gaji.admin.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GajiAccountDto {
    private int feeIncome; 
    private int transactionId; 
}