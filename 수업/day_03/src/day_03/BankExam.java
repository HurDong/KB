package day_03;

public class BankExam {
	public static void main(String[] args) {
		UserDto ud = new UserDto(1234,"홍길동","hong@gmail.com","111-222",false);
		System.out.println(ud.toString());
		AccountDto ad = new AccountDto(5678,"1111-2222",100,1234);
		System.out.println(ad.toString());
	}
}
