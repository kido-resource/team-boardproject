package com.shinhan.common;

import java.util.List;
import java.util.Scanner;

public class UpdateController implements CommonControllerInterface {
	static Scanner sc = new Scanner(System.in);
	static BoardService boardService = new BoardService();
	static BoardView view = new BoardView();

	public void execute() {
	
		boolean isStop = false;
		while (!isStop) {
			List<BoardDTO> result = boardService.selectAll();
			BoardView.display(result,1);
			System.out.print("수정을 원하시는 글번호를 입력하세요. 메인메뉴를 보시려면 0 을 눌러주세요. >>");
			int check = sc.nextInt();
			switch (check) {
			case 0 -> {
				isStop = true;
			}
			default -> {
				updateboard_selectByID(check);
			}
			}
		}
	}

	private void updateboard_selectByID(int check) {
		boolean isStop = false;
		// 상세 글정보 보여주기
		SelectController.board_selectByID(check);
		BoardDTO board = boardService.selectBoardById(check);

		view.updateMenu(); // 메뉴선택하기

		while (!isStop) {
			String menu = sc.nextLine().trim();
			switch (menu) {
			case "1" -> {
				// 제목 수정
				System.out.print("수정할 제목을 입력하세요. >> ");
				String newTitle = sc.nextLine().trim();
				int num = boardService.updateTitle(board, newTitle);
				if (num >= 1) {
					System.out.println("** 정상적으로 수정되었습니다. **");
				}
				isStop = true;
			}
			case "2" -> {
				// 내용 수정
				System.out.print("수정할 내용을 입력하세요. >> ");
				String newCommnet = sc.nextLine().trim();
				int num = boardService.updateComment(board, newCommnet);
				if (num >= 1) {
					System.out.println("** 정상적으로 수정되었습니다. **");
				}
				isStop = true;
			}
			case "3" -> {
				isStop = true;
			}

			}
		}

	}

}
