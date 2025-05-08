package com.shinhan.common;

import java.util.Scanner;

public class FrontController {
    private BoardDAO dao = new BoardDAO();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            menuDisplay();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> f_writePost();
                case 2 -> f_showPosts();
                case 5 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void menuDisplay() {
        System.out.println("======== '팀' 게시판 ==========");
        System.out.println("1. 글 쓰기");
        System.out.println("2. 글 조회");
        System.out.println("3. 글 수정");
        System.out.println("4. 글 삭제");
        System.out.println("5. 프로그램 종료");
        System.out.println("==================================");
        System.out.print("메뉴 선택 >> ");
    }

    private void f_writePost() {
        System.out.print("작성자 >> ");
        String nickname = sc.nextLine();
        System.out.print("제목 >> ");
        String title = sc.nextLine();
        System.out.print("내용 >> ");
        String comment = sc.nextLine();

        BoardDTO dto = BoardDTO.builder()
                .nickname(nickname)
                .title(title)
                .comment(comment)
                .create_date(new java.sql.Date(System.currentTimeMillis()))
                .build();

        dao.insert(dto);
        System.out.println("글이 등록되었습니다.");
    }

    private void f_showPosts() {
        System.out.println("글번호 | 제목 | 작성자 | 작성일");
        dao.selectAll().forEach(dto -> {
            System.out.printf("%d | %s | %s | %s\n",
                    dto.getBoard_id(),
                    dto.getTitle(),
                    dto.getNickname(),
                    dto.getCreate_date());
        });
    }
}

