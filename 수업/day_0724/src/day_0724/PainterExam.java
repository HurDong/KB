package day_0724;

/*
 * OOP에서의 클래스 종류
 * 1. VO, DTO : 데이터 정의 및 저장용(명사형) ex) PersonVo, StudentVo,...
 *              필요한만큼 많이 생성
 * 2. Service, Manager : VO를 관리하는 클래스(CRUD)
 *                       ex) PersonService, StudentService,...
 *                           add(...), find(...), update(...), delete(...),..
 * 3. UI : 데이터 입력, 출력 (GUI, WebUI)
 * 4. IO : 데이터 영구저장 및 전송(파일, DBMS, 네트워크를통한 데이터의 영구저장)
 * 
 * 자바 컴파일러가 기본으로 점검하는 내용
 * - extends 선언하지 않으면 extends Object 강제 추가
 * - 생성자에서 다른 생성자 호출하는 코드가 없으면 super() 강제 삽입
 * - 같은 클래스내 다른 생성자 호출 : this(...)
 * - 부모클래스 생성자 호출 : super(...)
 */

/** 자바 그림판 메인 테스트 클래스 */
public class PainterExam {

	public static void main(String[] args) {
		// 도형 객체 생성(선, 원, 사각형, 다각형)
		// 선 : x1, y1, x2, y2
		// 원 : x, y, radius
		// 사각형 : x, y, width, height
		// MyShape : 도형의 부모클래스 도형들의 공통 변수, 메서드를 정의 x, y, draw()

		MyLine l = new MyLine(3, 3, 5, 5); // 선 객체

	}
}
