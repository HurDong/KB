package day_03;

/** 상품 기본 정보 정의용 클래스 */
public class Product {
	String code; 	// 상품코드
	String name; 	// 상품이름
	String company; // 상품 제조사
	int price; 		// 상품가격  // 위에 4개는 heap영역에 생성(객체 필드 생성시에 생성)
	static int count = 0; // 클래스 소속이므로 null값을 갖는 객체도 해당 필드를 호출가능. -> method영역(항상)에 생성
						  // 클래스 당 한개
	
	public Product(String code, String name, String company, int price) {
		this.code = code;
		this.name = name;
		this.company = company;
		this.price = price;
		count++;
	}

	public void printInfo() {
		System.out.println("코드 : " + code + " / 이름 : " + name + " / 제조사 : " + company + " / 가격 : " + price);
	}
	
	static public void prn() {
//		Product p1 = new Product("11","111","1111",111); 
//		p1.price = 100;
		
// 		price = 100; price는 non-static 변수이므로 static 메서드 내에 사용 불가능
		count = 100;
//		this.price = 100; 에러 -> this는 static에서 사용불가능
	}	
	
}
