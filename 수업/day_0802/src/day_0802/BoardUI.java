package day_0802;

import java.util.List;
import java.util.Scanner;

import day_0802.dao.RecordNotFoundException;
import day_0802.vo.BoardDto;

/*
 * UI(입출력 담당)
 * -> Service(서비스 처리, 업무 코드 - 로그인, 로그아웃, 주문, 결제,...)
 *    로그인(id,pass) - id검사, 암호동일검사
 * -> Dao(자원을 직접처리)
 * -> JDBC
 * -> DBMS
 * BoardUI(입출력 담당)
 * -> BoardService(인터페이스) -> BoardServiceImpl(클래스)
 * -> BoardDao(인터페이스) -> BoardDaoImpl(클래스)
 * -> BoardDto
 */

public class BoardUI {
	public static void main(String[] args) {
		new BoardUI().go(); // static 함수가 아니므로 객체를 만들어서 메서드호출
	}

	private void go() {
		init(); // 필요 변수 초기화
		list(); // 게시물 목록 출력
		while (true) {
			mainMenu(); // 메인 메뉴 출력
		}
//		readMenu();
	}

	private void mainMenu() {
		System.out.println("메인 메뉴 : (1) 등록 (2) 목록 (3) 상세보기 (4) 종료 (5) 수정 (6) 삭제");
		System.out.print("메뉴 선택 : ");
		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			addBoard();
			break;
		case 2:
			list();
			break;
		case 3:
			readBoard();
			break;
		case 4:
			System.exit(0); // VM 종료
			break;
		case 5:
			updateBoard();
			break;
		case 6:
			deleteBoard();
			break;
		}

	}

	private void deleteBoard() {
		System.out.println("삭제할 게시물 번호를 입력하세요 >> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			brdSvc.delete(no);
		} catch (BoardException e) {
			System.out.println("--- 게시판 서버 오류입니다 ---");
		} catch (RecordNotFoundException e) {
			System.out.println("--- 존재하지 않는 게시물입니다 ---");
		}
	}

	private void updateBoard() {
		System.out.println("수정할 게시물 번호를 입력하세요 >> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			BoardDto dto;
			dto = brdSvc.read(no);
			System.out.println("제목을 입력하세요 >> ");
			String title = sc.nextLine();
			System.out.println("작성자를 입력하세요 >> ");
			String writer = sc.nextLine();
			System.out.println("내용을 입력하세요 >> ");
			String content = sc.nextLine();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			brdSvc.update(dto);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (BoardException e) {
			System.out.println("--- 게시판 서버 오류입니다 ---");
		}
	}

	private void readBoard() { // 게시물 상세 보기
		System.out.println("게시물 번호를 입력하세요 >> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			BoardDto dto;
			dto = brdSvc.read(no);
			System.out.println("** 상세보기 **");
			System.out.println("번호 :" + dto.getNo());
			System.out.println("제목 :" + dto.getTitle());
			System.out.println("작성자 :" + dto.getWriter());
			System.out.println("작성일:" + dto.getRegDate());
			System.out.println("내용 :" + dto.getContent());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (BoardException e) {
			System.out.println("--- 게시판 서버 오류입니다 ---");
		}
	}

	private void addBoard() {
		System.out.println("*** 게시물 등록 ***");
		System.out.println("제목을 입력하세요 >> ");
		String title = sc.nextLine();
		System.out.println("작성자를 입력하세요 >> ");
		String writer = sc.nextLine();
		System.out.println("내용을 입력하세요 >> ");
		String content = sc.nextLine();
		BoardDto dto = new BoardDto(0, title, writer, null, content);
		try {
			brdSvc.add(dto);
		} catch (BoardException e) {
			System.out.println("게시물 등록 오류");
		}

	}

	private BoardService brdSvc; // 게시판 서비스

	private Scanner sc;

	private void init() {
		brdSvc = new BoardServiceImpl();
		sc = new Scanner(System.in);
	}

	private void list() {
		System.out.println("[게시물 목록]");
		System.out.println("번호 ----- 작성자 ----- 제목 ------- 작성일");
		List<BoardDto> list;
		// 오류 메시지를 웹상으로 출력해야하므로 try catch
		try {
			list = brdSvc.list();
			for (BoardDto dto : list) {
				System.out.println(dto.getNo() + "         " + dto.getWriter() + "     " + dto.getTitle() + "         "
						+ dto.getRegDate());
			}
		} catch (BoardException e) {
			System.out.println("*** 서버에 오류가 발생했습니다 ***");
		}

	}
}
