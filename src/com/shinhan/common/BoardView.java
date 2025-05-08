package com.shinhan.common;

import java.util.List;

public class BoardView {
	public static void display(String message) {
		System.out.println(message);
	}
	
	public static void display(List<BoardDTO> result) {
		if (result == null || result.isEmpty()) {
			System.out.println("");
			System.out.println("해당하는 글번호가 존재하지 않습니다.");
			System.out.println("");
		}
		System.out.println("");
		System.out.println("======== 글 조회 ========");
		for (BoardDTO e : result) {
            System.out.println("작성자 : "+e.getNickname());
            System.out.println("작성일 : "+e.getCreate_date());
            System.out.println("수정일 : "+e.getUpdate_date());
            System.out.println("제목 : "+e.getTitle());
            System.out.println("내용 : "+e.getCommnet());
            System.out.println("");
        }
	}
	
	public void updateMenu() {
		System.out.println("-".repeat(30));
		System.out.println("1. 제목 수정하기\t2. 내용 수정하기\t3. 뒤로가기");
		System.out.print(">>");
	}
}
