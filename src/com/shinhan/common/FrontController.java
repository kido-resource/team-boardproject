package com.shinhan.common;

import java.util.Scanner;

public class FrontController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		CommonControllerInterface controller = null;
		while (!isStop) {
			display();
			String job = sc.next();
			switch (job) {
			case "1" -> {
				controller = ControllerFactory.make("insert");
			}
			case "2" -> {
				controller = ControllerFactory.make("select");
			}
			case "3" -> {
				controller = ControllerFactory.make("update");
			}
			case "4" -> {
				controller = ControllerFactory.make("delete");
			}
			case "5" -> {
				isStop = true;
				continue;
			}
			default ->{continue;}
			}
			
			controller.execute();

			
		}
		sc.close();
		System.out.println("이용해주셔서 감사합니다.");
		
	}

	private static void display() {

		System.out.println("======== \"팀이름\" 게시판 ==========");
		System.out.println("1. 글 쓰기");
		System.out.println("2. 글 조회");
		System.out.println("3. 글 수정");
		System.out.println("4. 글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("================================");
	}
}
