package kh.spring.gaji.user.model.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserCountReportDomain {
	private String userId;
	private String name;
	private int inviteCount;
	private int reportCount;
	private int tradeCount;
}