package Libraray;

public class LibraryExam {
	public static void main(String[] args) {
		// 도서 대여 : 책 이름, 등록 번호, 책 장르, 작가
		// 비디오테이프 대여 : 비디오테이프 이름, 등록 번호, 비디오테이프 장르, 평점
		// CD 대여 : CD 이름, 등록 번호, CD 장르, 원가
		BookShare b = new BookShare("홍길동전", 1, "고전", "미상");
		VideoShare v = new VideoShare("스타워즈", 2, "액션", 5);
		CDShare c = new CDShare("ㅁㅁㅁ게임", 3, "액션", 1000);
	}
}
