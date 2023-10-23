package kh.spring.gaji.admin.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserListDto {
	// ref_id, reporter_id, gr.report_category, gr.CREATED_AT, approval_status
	private String userId;
	private double ratingScore;
	private String createdAt;
	private int enabled;
	private int safetradecount;
	private int sellgoods;
	private int reportcount;
	private int refId;
	private String reporterId;
	private int reportCategory;
	private String approvalStatus;
	private String content;
	private String title;
	
	 
}
