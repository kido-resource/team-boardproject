package com.shinhan.common;

import java.util.List;
 
public class BoardService {
	public static List<BoardDTO> SelectBoardId(BoardDTO insert) {
		return BoardDAO.SelectBoardId(insert);
	}
	
	public static int Insert(BoardDTO con) {
		return BoardDAO.Insert(con);
	}
	 public List<BoardDTO> selectAll() {
		 return BoardDAO.selectAll();
	 }
	
	public static int SelectId(BoardDTO con) {
		return BoardDAO.SelectId(con);
	}

	public int updateComment(BoardDTO board, String newComment) {
		// 내용 수정하기 
		return BoardDAO.updateComment(board,newComment);
	}

	public int updateTitle(BoardDTO board, String newTitle) {
		// 제목 수정하기 
		return BoardDAO.updateTitle(board, newTitle);
	}

	public BoardDTO selectBoardById(int check) {
		// TODO Auto-generated method stub
		return BoardDAO.selectBoardById(check);
	}

	public int deleteBoardById(int check) {
		return BoardDAO.deleteBoardById(check);
	}

}
