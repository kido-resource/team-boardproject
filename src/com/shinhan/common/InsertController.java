package com.shinhan.common;

import java.util.Scanner;

public class InsertController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static BoardService insert = new BoardService();
	
	public void execute() {
		boolean isStop = false;
		board_insert();
	}

	private static void board_insert() {
		System.out.println("======== 글 쓰기 ========");
		System.out.print("작성자를 입력하세요 >>");
		String nickname = sc.next();
		System.out.print("제목을 입력하세요 >> ");
		String title = sc.next();
		System.out.print("내용을 입력하세요 >>");
		String commnet = sc.next();
		
		BoardDTO insert = BoardDTO.builder()
				.nickname(nickname)
				.title(title)
				.commnet(commnet)
				.build();
		int result = BoardService.Insert(insert);
		int result1 = BoardService.SelectId(insert);
		BoardView.display("삽입된"+result +"건의 게시물 번호는 "+result1+"번 입니다.");
		System.out.println("");
	
	}
}
