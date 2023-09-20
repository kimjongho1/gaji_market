package kh.spring.gaji.user.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserCountReportDto {
	private String userId;
	private String name;
	private int inviteCount;
	private int reportCount;
	private int tradeCount;
}