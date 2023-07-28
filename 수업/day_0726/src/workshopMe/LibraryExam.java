package workshopMe;

public class LibraryExam {
	public static void main(String[] args) {
		LibraryService libSvc = new LibraryService();
		//회원등록
		libSvc.add(new Member("user01","홍","1111","010-111"));
		libSvc.add(new Member("user02","김","2222","010-222"));
		libSvc.add(new Member("user01","박","3333","010-333"));//예외발생
		//물건등록
		libScv.add(new Book(100,"자바기본",20000,"한빛출판사",3));
		libScv.add(new Video(200,"자바강좌",15000,"명랑출판사",3));
		libScv.add(new CD(300,"자바실습",15000,"자바출판사",3));
		libScv.add(new Book(100,"자바기본",20000,"한빛출판사",3));//수량증가
		//회원검색
		ArrayList<Member> findArr = libSvc.findMemberByName("홍");
		Member m = libSvc.findMemberById("user01");
		//물건검색
		Item i = libSvc.findItemByTitle("자바기본");
		//대여  rend(대여물건id, 대여자id, 대여날짜,대여시,분,수량) 
		libSvc.rent( i.getRendId(), m.getId(), "20230726",13,7,1  )
		libSvc.rent( i.getRendId(), m.getId(), "20230725",10,20,1  )
		//반납  return(대여물건id, 대여자id, 반납날짜,반납시,반납분,수량)
		libSvc.rent( i.getRendId(), m.getId(), "20230726",10,20,1  )
	}
}
