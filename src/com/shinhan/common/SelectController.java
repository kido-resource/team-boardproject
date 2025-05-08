package com.shinhan.common;

import java.util.List;
import java.util.Scanner;
import com.shinhan.common.CommonControllerInterface;

public class SelectController implements CommonControllerInterface {

	static Scanner sc = new Scanner(System.in);
	static BoardService insert = new BoardService();
	private BoardDAO dao = new BoardDAO();

	public void execute() {

		boolean isStop = false;
		while (!isStop) {
			List<BoardDTO> result = dao.selectAll();
			BoardView.display(result, 1);

			System.out.print("상세조회할 글번호를 입력하세요. 메인메뉴를 보시려면 0 을 눌러주세요. >>");
			int check = sc.nextInt();
			switch (check) {
			case 0 -> {
				isStop = true;
			}
			default -> {

				board_selectByID(check);
			}
			}
		}
	}

	public static void board_selectByID(Integer board_id) {

		BoardDTO insert = BoardDTO.builder().board_id(board_id).build();
		List<BoardDTO> result = BoardService.SelectBoardId(insert);
		BoardView.display(result);
	}

}