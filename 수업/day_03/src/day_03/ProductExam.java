package day_03;

public class ProductExam {
	public static void main(String[] args) {
		Product p1 = new Product("a100","냉장고","삼성",100);
		p1.printInfo();		
//		p1.count++; // 비추천 -> Product.count++; 로 호출하는 것을 추천.
		
		Product p2 = null;
		// p2.price = 100; -> null값을 갖는 객체에 변수를 호출하면 에러발생. Method영역에 Product.count 생성
//		System.out.println(p2.count);
		System.out.println(Product.count);
		
		Product p3 = new Product(null, null, null, 0);
		System.out.println(Product.count);
	}
}
