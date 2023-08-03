package Main;

import java.util.Scanner;

public class HospitalUI {
	public static final String ANSI_BRIGHT_RED = "\u001B[91m";
	public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
	public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
	public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
	public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
	public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
	public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
	public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_ORANGE = "\u001B[38;5;214m";

	public static void main(String[] args) {
		new HospitalUI().go();
	}

	private Scanner sc;

	private void go() {
		init(); // 필요 변수 초기화
		while (true) {
			mainMenu(); // 메인 메뉴 출력
		}
	}

	private void init() {
//		dSvc = new DepartmentServiceImpl();
//		eSvc = new EmployeeServiceImpl();
//		hSvc = new HospitalizationServiceImpl();
//		pSvc = new PatientServiceImpl();
//		paySvc = new PaymentServiceImpl();
//		rSvc = new ReservationServiceImpl();
		sc = new Scanner(System.in);
	}

	private void mainMenu() {
		System.out.println(ANSI_BRIGHT_PURPLE + "#######################");
		System.out.println("#                     #");
		System.out.println(ANSI_BRIGHT_RED + "#    1. 직원 정보 조회    #");
		System.out.println(ANSI_ORANGE + "#    2. 환자 정보 조회    #");
		System.out.println(ANSI_BRIGHT_YELLOW + "#    3. 예약 정보 조회    #");
		System.out.println(ANSI_BRIGHT_GREEN + "#    4. 입원 정보 조회    #");
		System.out.println(ANSI_BRIGHT_CYAN + "#    5. 수납 정보 조회    #");
		System.out.println(ANSI_BRIGHT_BLUE + "#    6. 프로그램 종료     #");
		System.out.println(ANSI_BRIGHT_PURPLE + "#                     #");
		System.out.println("####################### " + ANSI_BRIGHT_WHITE);
		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			employeeView();
			break;
		case 2:
			patientView();
			break;
		case 3:
			reservationView();
			break;
		case 4:
			hospitalizationView();
			break;
		case 5:
			patientView();
			break;
		case 6:
			System.out.println(ANSI_BLACK + "프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("올바른 형식의 메뉴를 선택해주세요.");
			break;
		}
	}

	private void hospitalizationView() {

	}

	private void reservationView() {
	}

	private void patientView() {
	}

	private void employeeView() {
	}
}
