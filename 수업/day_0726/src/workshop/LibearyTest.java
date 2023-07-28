package workshop;

import java.util.ArrayList;

public class LibearyTest {
	public static void main(String[] args) throws 미등록물건Exception, 미등록회원idException, 수량부족Exception, 회원아이디중복Exception {
		LibraryService libSvc = new LibraryService();
		//회원등록
		libSvc.add(new 개인회원("user01","홍","1111","010-111"));
		libSvc.add(new 개인회원("user02","김","2222","010-222"));
		libSvc.add(new 개인회원("user01","박","3333","010-333"));//예외발생
		//물건등록
		libSvc.add(new 도서(100,"자바기본",20000,"한빛출판사",3));
		libSvc.add(new 비디오(200,"자바강좌",15000,"명랑출판사",3));
		libSvc.add(new CD(300,"자바실습",15000,"자바출판사",3));
		libSvc.add(new 도서(100,"자바기본",20000,"한빛출판사",3));//수량증가
		//회원검색
		ArrayList<개인회원> findArr = libSvc.findMemberByName("홍");
		개인회원 m = libSvc.findMemberById("user01");
		//물건검색
		MyItem i = libSvc.findItemByTitle("자바기본");
		//대여  rend(대여물건id, 대여자id, 대여날짜,대여시,분,수량) 
		libSvc.rent( i.getItemNo(), m.getId(), "20230726",13,7,1  );
		libSvc.rent( i.getItemNo(), m.getId(), "20230725",10,20,1  );
		//반납  returnItem(대여물건id, 대여자id, 반납날짜,반납시,반납분,수량)
		libSvc.returnItem( i.getItemNo(), m.getId(), "20230726",10,20,1  );

	}
}
