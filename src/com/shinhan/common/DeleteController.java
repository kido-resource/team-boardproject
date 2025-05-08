package com.shinhan.common;

import java.util.List;
import java.util.Scanner;

public class DeleteController implements CommonControllerInterface {
	static Scanner sc = new Scanner(System.in);
	static BoardService boardService = new BoardService();
	static BoardView view = new BoardView();
	
	public void execute() {
		
		boolean isStop = false;
		while (!isStop) {
			List<BoardDTO> result = boardService.selectAll();
			BoardView.display(result,1);
			System.out.print("삭제를 원하시는 글번호를 입력하세요. 메인메뉴를 보시려면 0 을 눌러주세요. >>");
			int check = sc.nextInt();
			switch (check) {
				case 0 -> {
					isStop = true;
				}
				default -> {
					deleteboard_selectByID(check);
				}
			}
		}
	}

	private void deleteboard_selectByID(int check) {
		boolean isStop = false;
		System.out.print("정말로 삭제하시겠습니까?(y/n) >> ");
	
		while(!isStop) {
			String answer = sc.nextLine().trim();
			switch(answer) {
				case "y" -> {
					int result = boardService.deleteBoardById(check);
					if(result >= 1) {
						System.out.println("** 정상적으로 삭제되었습니다. **");
					}else {
						System.out.println("** 삭제되지 않았습니다. **");
					}
					isStop = true;
					
				}
				case "n" -> {
					System.out.println("** 삭제되지 않았습니다. **");
					isStop = true;
				}
			}
		}
	}
}
