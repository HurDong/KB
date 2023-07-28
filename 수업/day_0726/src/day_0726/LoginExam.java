package day_0726;

public class LoginExam {
	public static void main(String[] args) {
		String id = "user100";
		String password = "1111";
		try {
			login(id, password);
			System.out.println("로그인 성공");
		} catch (unregisteredIDException e) {
			e.printStackTrace();
			System.out.println("메시지: " + e.getMessage());
		} catch (unregisteredPWException e) {
			e.printStackTrace();
			System.out.println("메시지: " + e.getMessage());
		}

	}

	private static void login(String id, String password) throws unregisteredIDException, unregisteredPWException {
		if (id != "user100") {
			throw new unregisteredIDException(id + "는 없는 아이디입니다.");
		}
		if (password != "1111") {
			throw new unregisteredPWException(password + "는 없는 암호입니다.");
		}
	}
}
