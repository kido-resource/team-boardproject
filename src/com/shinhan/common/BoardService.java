package com.shinhan.common;

import java.util.List;

public class BoardService {
	public static List<BoardDTO> SelectBoardId(BoardDTO insert) {
		return BoardDAO.SelectBoardId(insert);
	}
	
	public static int Insert(BoardDTO con) {
		return BoardDAO.Insert(con);
	}
	
	public static int SelectId(BoardDTO con) {
		return BoardDAO.SelectId(con);
	}

}
