package com.shinhan.common;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BoardDTO {
	private int board_id;
	private String title;
	private String comment;
	private Date create_date;
	private Date update_date;
	private String nickname;
	
}
