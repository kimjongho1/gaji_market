package kh.spring.gaji.user.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FavoriteUserDto {
	
	private String userId;
	private String targetId;
	private String createdDate;
}
