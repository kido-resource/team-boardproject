package com.shinhan.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    
    private Connection conn;

    // DB 연결 메서드
    private Connection getConnection() {
        try {
            // 오라클 JDBC 연결 문자열
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB URL
            String user = "hr"; // DB 사용자명
            String password = "hr"; // DB 비밀번호
            
            // DB 연결
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 1.글 삽입 
    public void insert(BoardDTO dto) {
        String sql = "INSERT INTO \"Board\" (\"board_id\", \"title\", \"comment\", \"create_date\", \"update_date\", \"nickname\") "
                   + "VALUES (seq_board_id.nextval, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getComment());
            pstmt.setDate(3, dto.getCreate_date());
            pstmt.setDate(4, dto.getUpdate_date());
            pstmt.setString(5, dto.getNickname());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. 글 전체 조회
    public List<BoardDTO> selectAll() {
        List<BoardDTO> boardList = new ArrayList<>();
        String sql = "SELECT \"board_id\", \"title\", \"comment\", \"create_date\", \"update_date\", \"nickname\" "
                   + "FROM \"Board\"";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BoardDTO dto = BoardDTO.builder()
                        .board_id(rs.getInt("board_id"))
                        .title(rs.getString("title"))
                        .comment(rs.getString("comment"))
                        .create_date(rs.getDate("create_date"))
                        .update_date(rs.getDate("update_date"))
                        .nickname(rs.getString("nickname"))
                        .build();
                boardList.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boardList;
    }

    
}
