package kh.spring.gaji.region.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DongDto {
	
	private int dongId;
	private int guId;
	private String dongName;
}
