package com.shinhan.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
	private int board_id;
	private String title;	
	private String commnet;
	private String create_date;
	private String update_date;
	private String nickname;
}
