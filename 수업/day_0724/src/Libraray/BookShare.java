package Libraray;

public class BookShare extends Share {
	// 책이름, 등록번호, 책 장르, 작가
	public String writer;

	public BookShare() {
		// TODO Auto-generated constructor stub
	}

	public BookShare(String name, int regNum, String genre, String writer) {
		super(name, regNum, genre);
		this.writer = writer;
	}
}
