package com.shinhan.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.shinhan.common.DBUtil;

public class BoardDAO {
	
	  // 2. 글 전체 조회
    public static List<BoardDTO> selectAll() {
        List<BoardDTO> boardList = new ArrayList<>();
        String sql = "SELECT board_id, title, commnet, create_date, update_date, nickname "
                   + "FROM Board";

        try (Connection conn = DBUtil.getConnection(); // ✅ 수정
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BoardDTO dto = BoardDTO.builder()
                        .board_id(rs.getInt("board_id"))
                        .title(rs.getString("title"))
                        .commnet(rs.getString("commnet"))
                        .create_date(rs.getString("create_date"))
                        .update_date(rs.getString("update_date"))
                        .nickname(rs.getString("nickname"))
                        .build();
                boardList.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boardList;
    }
	//select
	public static List<BoardDTO> SelectBoardId(BoardDTO boardid) {
		List<BoardDTO> boardlist = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT UPDATE_DATE, TITLE, NICKNAME, commnet, CREATE_DATE FROM BOARD WHERE BOARD_ID = "+boardid.getBoard_id();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				BoardDTO emp = BoardDTO.builder()
						.update_date(rs.getString("update_date"))
						.title(rs.getString("title"))
						.nickname(rs.getString("nickname"))
						.commnet(rs.getString("commnet"))
						.create_date(rs.getString("create_date"))
						.build();
				boardlist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return boardlist;
	}
	
	//insert
	public static int Insert(BoardDTO con) {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		String sql = """
				
				INSERT INTO BOARD 
				(NICKNAME, BOARD_ID, TITLE, commnet, CREATE_DATE) 
				VALUES (?,BoardId_seq.NEXTVAL,?,?,SYSDATE)
					 
				""";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, con.getNickname());
			st.setString(2, con.getTitle());
			st.setString(3, con.getCommnet());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DBUtil.dbDisConnect(conn, st, null);
		}
		return result;
	}
	
	
	public static int SelectId(BoardDTO con) {
			int result = 0;
			Connection conn = DBUtil.getConnection();
			Statement st = null;
			ResultSet rs = null;
			
			String sql = """
					
					SELECT MAX(BOARD_ID)
					FROM BOARD
						 
					""";
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				if (rs.next()) {
		            result = rs.getInt(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				DBUtil.dbDisConnect(conn, st, rs);
			}
			return result;
		}
	
	
}
