package hospital;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import hospital.dto.DiagnosisDto;
import hospital.dto.HospitalDepartmentDto;
import hospital.dto.HospitalEmployeeDto;
import hospital.dto.HospitalizationDto;
import hospital.dto.PatientDto;
import hospital.dto.PaymentDto;
import hospital.dto.ReservationDto;
import hospital.exception.DepartmentException;
import hospital.exception.DiagnosisException;
import hospital.exception.EmployeeException;
import hospital.exception.HospitalizationException;
import hospital.exception.PatientException;
import hospital.exception.PaymentException;
import hospital.exception.RecordNotFoundException;
import hospital.exception.ReservationException;
import hospital.service.DepartmentService;
import hospital.service.DepartmentServiceImpl;
import hospital.service.DiagnosisService;
import hospital.service.DiagnosisServiceImpl;
import hospital.service.EmployeeService;
import hospital.service.EmployeeServiceImpl;
import hospital.service.HospitalizationService;
import hospital.service.HospitalizationServiceImpl;
import hospital.service.PatientService;
import hospital.service.PatientServiceImpl;
import hospital.service.PaymentService;
import hospital.service.PaymentServiceImpl;
import hospital.service.ReservationService;
import hospital.service.ReservationServiceImpl;

public class HospitalUI {

	public static final String RED = "\u001B[91m";
	public static final String ORANGE = "\u001B[38;5;208m";
	public static final String YELLOW = "\u001B[33m";
	public static final String GREEN = "\u001B[92m";
	public static final String BLUE = "\u001B[94m";
	public static final String CYAN = "\u001B[96m";
	public static final String PURPLE = "\u001B[95m";
	public static final String GRAY = "\u001B[90m";
	public static final String BLACK = "\u001B[30m";

	public static void main(String[] args) throws ParseException {
		new HospitalUI().go();
	}

	private Scanner sc;

	private DepartmentService dSvc;
	private EmployeeService eSvc;
	private HospitalizationService hSvc;
	private PatientService pSvc;
	private PaymentService paySvc;
	private ReservationService rSvc;
	private DiagnosisService diaSvc;

	private void go() throws ParseException {
		init(); // 필요 변수 초기화
		while (true) {
			mainMenu(); // 메인 메뉴 출력
		}
	}

	private void init() {
		dSvc = new DepartmentServiceImpl();
		eSvc = new EmployeeServiceImpl();
		hSvc = new HospitalizationServiceImpl();
		pSvc = new PatientServiceImpl();
		paySvc = new PaymentServiceImpl();
		rSvc = new ReservationServiceImpl();
		diaSvc = new DiagnosisServiceImpl();
		sc = new Scanner(System.in);
	}

	private void mainMenu() throws ParseException {
		System.out.println(PURPLE + "\n###############################");
		System.out.println("#   번호   #       메뉴          #");
		System.out.println("###############################");
		System.out.println("#" + RED + "    1    " + PURPLE + "#" + BLACK + "    직원 관리 기능" + PURPLE + "     #");
		System.out.println("#" + ORANGE + "    2    " + PURPLE + "#" + BLACK + "    환자 관리 기능" + PURPLE + "     #");
		System.out.println("#" + YELLOW + "    3    " + PURPLE + "#    " + BLACK + "예약 관리 기능     " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4    " + PURPLE + "#    " + BLACK + "입원 관리 기능     " + PURPLE + "#");
		System.out.println("#" + CYAN + "    5    " + PURPLE + "#    " + BLACK + "수납 관리 기능     " + PURPLE + "#");
		System.out.println("#" + BLUE + "    6    " + PURPLE + "#    " + BLACK + "부서 관리 기능     " + PURPLE + "#");
		System.out.println("#" + BLUE + "    7    " + PURPLE + "#    " + BLACK + "진료 관리 기능     " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    8    " + PURPLE + "#    " + BLACK + "프로그램  종료     " + PURPLE + "#");
		System.out.println(PURPLE + "############################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");

		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			while (true) {
				if (employeeMenu()) {
					break;
				}
			}
			break;
		case 2:
			while (true) {
				if (patientMenu()) {
					break;
				}
			}
			break;
		case 3:
			while (true) {
				if (reservationMenu()) {
					break;
				}
			}
			break;
		case 4:
			while (true) {
				if (hospitalizationMenu()) {
					break;
				}
			}
			break;
		case 5:
			while (true) {
				if (paymentMenu()) {
					break;
				}
			}
			break;
		case 6:
			while (true) {
				if (departmentMenu()) {
					break;
				}
			}
			break;
		case 7:
			while (true) {
				if (diagnosisMenu()) {
					break;
				}
			}
			break;
		case 8:
			System.out.println(BLACK + "프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("올바른 형식의 메뉴를 선택해주세요.");
			break;
		}
	}

	// **********************************************************************************************************
	private boolean employeeMenu() {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#    " + BLACK + "👨‍⚕️ 직원 관리 기능 👩‍⚕️" + PURPLE + "  #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 직원 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 직원 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 직원 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 직원 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 직원 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			employeeInsert();
		} else if (menu == 2) {
			employeeView();
		} else if (menu == 3) {
			employeeUpdate();
		} else if (menu == 4) {
			employeeDelete();
			System.out.println("삭제 성공");
		} else if (menu == 5) {
			employeeCount();
		} else if (menu == 6) {
			return true;
		}
		return false;
	}

	private void employeeInsert() {
		System.out.println("👨‍⚕️ 직원 정보 등록 👩‍⚕️");
		System.out.print("이름을 입력하세요 >> ");
		String name = sc.nextLine();
		System.out.print("직원 코드를 입력하세요 >> ");
		int employeeCode = Integer.parseInt(sc.nextLine());
		System.out.print("연락처를 입력하세요 >> ");
		String phoneNumber = sc.nextLine();
		System.out.print("소속 부서코드를 입력하세요 >> ");
		int dId = Integer.parseInt(sc.nextLine());

		HospitalEmployeeDto dto = new HospitalEmployeeDto(0, dId, name, employeeCode, phoneNumber);
		try {
			eSvc.add(dto);
		} catch (EmployeeException e) {
			e.printStackTrace();
			System.out.println("직원 등록 오류");
		}
	}

	private void employeeView() {
		System.out.println("👨‍⚕️ 직원 정보 조회 👩‍⚕️");
		employeeList();
	}

	private void employeeList() {
		List<HospitalEmployeeDto> list;
		try {
			list = eSvc.list();
			System.out.println("직원번호  이름  직원코드   전화번호     부서id");
			for (HospitalEmployeeDto dto : list) {
				System.out.println(dto.geteId() + "     " + dto.getName() + "    " + dto.getEmpCode() + "   "
						+ dto.getPhoneNumber() + "    " + dto.getdId());
			}
		} catch (EmployeeException e) {
			System.out.println("");
		}
	}

	private void employeeUpdate() {
		System.out.println("👨‍⚕️ 직원 정보 수정 👩‍⚕️");
		System.out.println("수정하고 싶은 직원 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			HospitalEmployeeDto dto = eSvc.read(no);
			System.out.println("** 직원 정보 수정 **");
			System.out.println("이름을 입력하세요>> ");
			String name = sc.nextLine();
			System.out.println("번호를 입력하세요>> ");
			String phoneNumber = sc.nextLine();

			eSvc.update(new HospitalEmployeeDto(no, dto.getdId(), name, dto.getEmpCode(), phoneNumber));
			System.out.println("수정완료");
		} catch (EmployeeException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("없는 직원입니다");
		}
	}

	private void employeeDelete() {
		System.out.println("👨‍⚕️ 직원 정보 삭제 👩‍⚕️");
		System.out.println("삭제하고 싶은 직원 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			eSvc.delete(no);
		} catch (EmployeeException e) {
			System.out.println("서버에 오류가 발생했습니다");
		} catch (RecordNotFoundException e) {
			System.out.println("없는 직원입니다");
		}
	}

	private void employeeCount() {
		try {
			System.out.println("직원수: " + eSvc.count());
		} catch (EmployeeException e) {
			System.out.println("서버에 오류가 발생했습니다");
		}
	}

	// **********************************************************************************************************
	private boolean patientMenu() {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#   " + BLACK + "🤕 환자 관리 기능 🤕" + PURPLE + "   #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 환자 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 환자 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 환자 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 환자 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 환자 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			patientInsert();
		} else if (menu == 2) {
			patientView();
		} else if (menu == 3) {
			patientUpdate();
		} else if (menu == 4) {
			patientDelete();
			System.out.println("삭제 성공");
		} else if (menu == 5) {
			patientCount();
		} else if (menu == 6) {
			return true;
		}
		return false;
	}

	private void patientInsert() {
		System.out.println("🤕 환자 정보 등록 🤕");
		System.out.println("이름을 입력하세요 >> ");
		String name = sc.nextLine();
		System.out.println("생년월일을 입력하세요 >> ");
		String birth = sc.nextLine();
		System.out.println("성별을 입력하세요 >> ");
		String gender = sc.nextLine();
		System.out.println("연락처를 입력하세요 >> ");
		String phoneNumber = sc.nextLine();
		System.out.println("주소를 입력하세요 >> ");
		String address = sc.nextLine();

		PatientDto dto = new PatientDto(-1, name, birth, gender, phoneNumber, address);
		try {
			pSvc.add(dto);
		} catch (PatientException e) {
			e.printStackTrace();
			System.out.println("환자 등록 오류");
		}
	}

	private void patientView() {
		System.out.println("🤕 환자 정보 조회 🤕");
		patientList();
	}

	private void patientList() {
		List<PatientDto> list;
		try {
			list = pSvc.list();
			System.out.println("환자번호  이름   생년월일   성별     전화번호                주소");
			for (PatientDto dto : list) {
				System.out.println(dto.getpId() + "      " + dto.getName() + "   " + dto.getBirth() + "  "
						+ dto.getGender() + "    " + dto.getPhoneNumber() + "    " + dto.getAddress());
			}
		} catch (PatientException e) {
			System.out.println("");
		}
	}

	private void patientUpdate() {
		System.out.println("🤕 환자 정보 수정 🤕");
		System.out.println("수정하고 싶은 환자 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			System.out.println("** 환자 정보 수정 **");
			System.out.println("이름을 입력하세요>> ");
			String name = sc.nextLine();
			System.out.println("생년월일을 입력하세요>> ");
			String birth = sc.nextLine();
			System.out.println("성별을 입력하세요>> ");
			String gender = sc.nextLine();
			System.out.println("전화번호를 입력하세요>> ");
			String phoneNumber = sc.nextLine();
			System.out.println("주소를 입력하세요>> ");
			String address = sc.nextLine();

			pSvc.update(new PatientDto(no, name, birth, gender, phoneNumber, address));
			System.out.println("수정완료");
		} catch (PatientException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("없는 환자입니다");
		}
	}

	private void patientDelete() {
		System.out.println("🤕 환자 정보 삭제 🤕");
		System.out.println("삭제하고 싶은 환자 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			pSvc.delete(no);
		} catch (PatientException e) {
			System.out.println("서버에 오류가 발생했습니다");
		} catch (RecordNotFoundException e) {
			System.out.println("없는 환자입니다");
		}
	}

	private void patientCount() {
		try {
			System.out.println("환자수: " + pSvc.count());
		} catch (PatientException e) {
			System.out.println("서버에 오류가 발생했습니다");
		}
	}

	// **********************************************************************************************************
	private boolean reservationMenu() throws ParseException {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#   " + BLACK + "📝 예약 관리 기능 📝" + PURPLE + "   #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 예약 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 예약 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 예약 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 예약 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 예약 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");

		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			reservationInsert();

		} else if (menu == 2) {
			reservationView();

		} else if (menu == 3) {
			reservationUpdate();

		} else if (menu == 4) {
			reservationDelete();

		} else if (menu == 5) {
			reservationCount();

		} else if (menu == 6) {
			return true;

		}

		return false;
	}

	private void reservationView() {
		System.out.println("📝 예약 정보 조회 📝");
		reservationList();
	}

	private void reservationList() {
		List<ReservationDto> list;
		try {
			list = rSvc.list();
			System.out.println("예약번호  의사id    예약일     예약시간     환자id");
			for (ReservationDto dto : list) {
				System.out.println(dto.getrId() + "       " + dto.getDoctorId() + "    " + dto.getReservationDate()
						+ "  " + dto.getReservationTime() + "     " + dto.getpId());
			}
		} catch (ReservationException e) {
			System.out.println("");
		}
	}

	private void reservationInsert() throws ParseException { // Date 관련 예외처리
		System.out.println("📝 예약 정보 등록 📝");
		System.out.println("담당의 ID를 입력하세요 >> ");
		int doctorId = Integer.parseInt(sc.nextLine());
		System.out.println("환자 ID를 입력하세요 >> ");
		int pId = Integer.parseInt(sc.nextLine());
		System.out.println("예약 일자를 입력하세요(yyyy-MM-dd) >> ");
		String str = sc.nextLine();
		Date reservationDate = Date.valueOf(str);
		System.out.println("예약 시간을 입력하세요 >> ");
		String reservationTime = sc.nextLine();

		ReservationDto dto = new ReservationDto(0, pId, doctorId, reservationDate, reservationTime);

		try {
			rSvc.add(dto);

		} catch (ReservationException e) {
			e.printStackTrace();
			System.out.println("예약 등록 오류");
		}

	}

	private void reservationUpdate() throws ParseException {
		System.out.println("📝 예약 정보 수정 📝");
		System.out.println("수정하고 싶은 예약 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			System.out.println("** 에약 정보 수정 **");
			System.out.println("담당의 ID를 입력하세요>> ");
			int doctorId = Integer.parseInt(sc.nextLine());

			System.out.println("환자 ID를 입력하세요>> ");
			int pId = Integer.parseInt(sc.nextLine());

			System.out.println("예약 변경 날짜를 입력하세요(yyyy-MM-dd) >> ");
			String str = sc.nextLine();
			Date reservationDate = Date.valueOf(str);

			System.out.println("예약 변경 시간을 입력하세요 >> ");
			String reservationTime = sc.nextLine();

			rSvc.update(new ReservationDto(no, pId, doctorId, reservationDate, reservationTime));

			System.out.println("수정완료");

		} catch (ReservationException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("없는 예약입니다");
		}

	}

	private void reservationDelete() {
		System.out.println("📝 예약 정보 삭제 📝");
		System.out.println("삭제하고 싶은 예약 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			rSvc.delete(no);
		} catch (ReservationException e) {
			System.out.println("서버에 오류가 발생했습니다");

		} catch (RecordNotFoundException e) {
			System.out.println("없는 예약입니다");
		}

	}

	private void reservationCount() {
		try {
			System.out.println("예약수: " + rSvc.count());
		} catch (ReservationException e) {
			System.out.println("서버에 오류가 발생했습니다");
		}
	}

	// **********************************************************************************************************
	private boolean hospitalizationMenu() {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#   " + BLACK + "🛏️ 입원 관리 기능 🛏️" + PURPLE + "   #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 입원 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 입원 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 입원 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 입원 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 입원 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			hospitalizationInsert();
		} else if (menu == 2) {
			hospitalizationView();
		} else if (menu == 3) {
			hospitalizationUpdate();
		} else if (menu == 4) {
			hospitalizationDelete();
		} else if (menu == 5) {
			hospitalizationCount();
		} else if (menu == 6) {
			return true;
		}
		return false;
	}

	private void hospitalizationInsert() {
		System.out.println("🛏️ 입원 정보 등록 🛏️");
		System.out.println("환자번호를 입력하세요 >> ");
		int pId = Integer.parseInt(sc.nextLine());
		System.out.println("의사번호를 입력하세요 >> ");
		int doctorId = Integer.parseInt(sc.nextLine());
		System.out.println("병실호수를 입력하세요 >> ");
		String roomNumber = sc.nextLine();
		System.out.println("입원일을 입력하세요(yyyy-mm-dd) >> ");
		String str = sc.nextLine();
		Date admissionDate = Date.valueOf(str);
		System.out.println("퇴원일을 입력하세요(yyyy-mm-dd) >> ");
		String str2 = sc.nextLine();
		Date dischargeDate = Date.valueOf(str2);

		HospitalizationDto dto = new HospitalizationDto(0, pId, doctorId, roomNumber, admissionDate, dischargeDate);
		try {
			hSvc.add(dto);
		} catch (HospitalizationException e) {
			e.printStackTrace();
			System.out.println("입원 등록 오류");
		}
	}

	private void hospitalizationView() {
		System.out.println("🛏️ 입원 정보 조회 🛏️");
		hospitalizationList();
	}

	private void hospitalizationList() {
		List<HospitalizationDto> list;
		try {
			list = hSvc.list();
			System.out.println("입원번호  의사id    병실호수    입원일     퇴원일");
			for (HospitalizationDto dto : list) {
				System.out.println(dto.gethId() + "        " + dto.getDoctorId() + "       " + dto.getRoomNumber()
						+ "  " + dto.getAdmissionDate() + "  " + dto.getDischargeDate());

			}
		} catch (HospitalizationException e) {
			System.out.println("");
		}
	}

	private void hospitalizationUpdate() {
		System.out.println("🛏️ 입원 정보 수정 🛏️");
		System.out.println("수정하고 싶은 입원 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			HospitalizationDto dto = hSvc.read(no);
			System.out.println("** 입원 정보 수정 **");
			System.out.println("환자번호를 입력하세요 >> ");
			int pId = Integer.parseInt(sc.nextLine());
			System.out.println("의사번호를 입력하세요 >> ");
			int doctorId = Integer.parseInt(sc.nextLine());
			System.out.println("병실호수를 입력하세요 >> ");
			String roomNumber = sc.nextLine();

			System.out.println("퇴원일을 입력하세요(yyyy-mm-dd) >> ");
			String str2 = sc.nextLine();
			Date dischargeDate = Date.valueOf(str2);

			hSvc.update(new HospitalizationDto(0, pId, doctorId, roomNumber, dto.getAdmissionDate(), dischargeDate));

			System.out.println("수정완료");

		} catch (HospitalizationException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("없는 예약입니다");
		}

	}

	private void hospitalizationDelete() {
		System.out.println("🛏️ 입원 정보 삭제 🛏️");
		System.out.println("삭제하고 싶은 입원 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			hSvc.delete(no);
		} catch (HospitalizationException e) {
			System.out.println("서버에 오류가 발생했습니다");

		} catch (RecordNotFoundException e) {
			System.out.println("없는 입원정보입니다");
		}
	}

	private void hospitalizationCount() {
		System.out.println("🛏️ 입원 수 출력 🛏️");
		try {
			System.out.println("입원수: " + hSvc.count());
		} catch (HospitalizationException e) {
			System.out.println("서버에 오류가 발생했습니다");
		}
	}

	// **********************************************************************************************************
	private boolean paymentMenu() {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#   " + BLACK + "💰 수납 관리 기능 💰" + PURPLE + "   #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 수납 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 수납 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 수납 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 수납 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 수납 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");

		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			paymentInsert();

		} else if (menu == 2) {
			paymentView();

		} else if (menu == 3) {
			paymentUpdate();

		} else if (menu == 4) {
			paymentDelete();

		} else if (menu == 5) {
			paymentCount();

		} else if (menu == 6) {
			return true;
		}

		return false;
	}

	private void paymentView() {
		System.out.println("💰 수납 정보 조회 💰");
		paymentList();
	}

	private void paymentList() {
		List<PaymentDto> list;
		try {
			list = paySvc.list();
			System.out.println("수납번호  환자id   결제일    결제금액");
			for (PaymentDto dto : list) {
				System.out.println(dto.getPayId() + "       " + dto.getpId() + "   " + dto.getPaymentDate() + " "
						+ dto.getPaymentAmount());
			}
		} catch (PaymentException e) {
			System.out.println("");
		}
	}

	private void paymentInsert() {
		System.out.println("💰 수납 정보 등록 💰");
		System.out.println("수납 금액을 입력하세요 >> ");
		int paymentAmount = Integer.parseInt(sc.nextLine());

		System.out.println("환자 ID를 입력하세요 >> ");
		int pId = Integer.parseInt(sc.nextLine());

		PaymentDto dto = new PaymentDto(0, pId, Date.valueOf("1111-11-11"), paymentAmount);

		try {
			paySvc.add(dto);

		} catch (PaymentException e) {
			e.printStackTrace();
			System.out.println("수납 등록 오류");
		}

	}

	private void paymentUpdate() {
		System.out.println("💰 수납 정보 수정 💰");
		System.out.println("수정하고 싶은 수납 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			PaymentDto dto = paySvc.read(no);
			System.out.println("** 수납 정보 수정 **");

			System.out.println("수납 금액을 입력하세요 >> ");
			int paymentAmount = Integer.parseInt(sc.nextLine());

			paySvc.update(new PaymentDto(no, dto.getpId(), Date.valueOf("1111-11-11"), paymentAmount));
			System.out.println("수정완료");

		} catch (PaymentException e) {

			e.printStackTrace();

		} catch (RecordNotFoundException e) {

			System.out.println("없는 수납입니다");

		}

	}

	private void paymentDelete() {
		System.out.println("💰 수납 정보 삭제 💰");
		System.out.println("삭제하고 싶은 수납 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {

			paySvc.delete(no);

		} catch (PaymentException e) {
			System.out.println("서버에 오류가 발생했습니다");

		} catch (RecordNotFoundException e) {
			System.out.println("없는 수납입니다");

		}

	}

	private void paymentCount() {

		try {
			System.out.println("수납수: " + paySvc.count());

		} catch (PaymentException e) {
			System.out.println("서버에 오류가 발생했습니다.");

		}

	}

	// **********************************************************************************************************
	private boolean departmentMenu() {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#   " + BLACK + "🧑‍🤝‍🧑 부서 관리 기능 🧑‍🤝‍🧑" + PURPLE + "   #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 부서 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 부서 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 부서 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 부서 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 부서 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);
		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");

		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			departmentInsert();

		} else if (menu == 2) {
			departmentView();

		} else if (menu == 3) {
			departmentUpdate();

		} else if (menu == 4) {
			departmentDelete();

		} else if (menu == 5) {
			departmentCount();

		} else if (menu == 6) {
			return true;

		}

		return false;
	}

	private void departmentInsert() {
		System.out.println("🧑‍🤝‍🧑 부서 정보 등록 🧑‍🤝‍🧑");
		System.out.println("부서 이름을 입력하세요 >> ");
		String departmentName = sc.nextLine();
		System.out.println("부서장 ID를 입력하세요 >> ");
		int managerId = Integer.parseInt(sc.nextLine());
		HospitalDepartmentDto dto = new HospitalDepartmentDto(0, departmentName, managerId);

		try {
			dSvc.add(dto);
		} catch (DepartmentException e) {
			e.printStackTrace();
			System.out.println("부서 등록 오류");
		}

	}

	private void departmentView() {
		System.out.println("🧑‍🤝‍🧑 부서 정보 조회 🧑‍🤝‍🧑");
		departmentList();
	}

	private void departmentList() {
		List<HospitalDepartmentDto> list;
		try {
			list = dSvc.list();
			System.out.println("부서번호  부서명  부서장id");
			for (HospitalDepartmentDto dto : list) {
				System.out.println(dto.getdId() + "      " + dto.getDepartmentName() + "    " + dto.getMangerId());
			}
		} catch (DepartmentException e) {
			System.out.println("");
		}
	}

	private void departmentUpdate() {
		System.out.println("🧑‍🤝‍🧑 부서 정보 수정 🧑‍🤝‍🧑");
		System.out.println("수정하고 싶은 부서 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			System.out.println("** 부서 정보 수정 **");
			System.out.println("부서명을 입력하세요>> ");
			String departmentName = sc.nextLine();
			System.out.println("부서장 ID를 입력하세요>> ");
			int managerId = Integer.parseInt(sc.nextLine());
			dSvc.update(new HospitalDepartmentDto(no, departmentName, managerId));
			System.out.println("수정완료");

		} catch (DepartmentException e) {

			e.printStackTrace();

		} catch (RecordNotFoundException e) {

			System.out.println("없는 부서입니다");

		}

	}

	private void departmentDelete() {
		System.out.println("🧑‍🤝‍🧑 부서 정보 삭제 🧑‍🤝‍🧑");
		System.out.println("삭제하고 싶은 부서 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {
			dSvc.delete(no);

		} catch (DepartmentException e) {
			System.out.println("서버에 오류가 발생했습니다");

		} catch (RecordNotFoundException e) {
			System.out.println("없는 부서입니다");

		}

	}

	private void departmentCount() {
		try {
			System.out.println("부서수: " + dSvc.count());
		} catch (DepartmentException e) {
			System.out.println("서버에 오류가 발생했습니다");
		}

	}

// **********************************************************************************************
	private boolean diagnosisMenu() {
		System.out.println(PURPLE + "\n#######################");
		System.out.println("#   " + BLACK + "🩺 진료 관리 기능 🩺" + PURPLE + "   #");
		System.out.println("#######################");
		System.out.println("#" + RED + "    1. 진료 정보 등록    " + PURPLE + "#");
		System.out.println("#" + ORANGE + "    2. 진료 정보 조회    " + PURPLE + "#");
		System.out.println("#" + YELLOW + "    3. 진료 정보 수정    " + PURPLE + "#");
		System.out.println("#" + GREEN + "    4. 진료 정보 삭제    " + PURPLE + "#");
		System.out.println("#" + BLUE + "    5. 진료 숫자 출력    " + PURPLE + "#");
		System.out.println("#" + PURPLE + "    6. 메인화면 가기     " + PURPLE + "#");
		System.out.println(PURPLE + "####################### " + GRAY);

		System.out.print("\n- 메뉴 번호를 입력해주세요 >> ");

		int menu = Integer.parseInt(sc.nextLine());

		System.out.println();

		if (menu == 1) {
			diagnosisInsert();

		} else if (menu == 2) {
			diagnosisView();

		} else if (menu == 3) {
			diagnosisUpdate();

		} else if (menu == 4) {
			diagnosisDelete();

		} else if (menu == 5) {
			diagnosisCount();

		} else if (menu == 6) {
			return true;
		}

		return false;

	}

	private void diagnosisInsert() {
		System.out.println("🩺 진료 정보 등록 🩺");
		System.out.print("의사 ID를 입력하세요 >> ");
		int doctorId = Integer.parseInt(sc.nextLine());
		System.out.print("환자 ID를 입력하세요 >> ");
		int pId = Integer.parseInt(sc.nextLine());
		System.out.print("진료 일자를 입력하세요(yyyy-MM-dd) >> ");
		String str = sc.nextLine();
		Date diagnosisDate = Date.valueOf(str);
		System.out.print("진료 내용을 입력하세요 >> ");
		String diagnosisContents = sc.nextLine();
		DiagnosisDto dto = new DiagnosisDto(0, pId, doctorId, diagnosisDate, diagnosisContents);
		try {
			diaSvc.add(dto);

		} catch (DiagnosisException e) {
			e.printStackTrace();
			System.out.println("진료 등록 오류");

		}

	}

	private void diagnosisView() {
		System.out.println("🩺 진료 정보 조회 🩺");
		diagnosisList();

	}

	private void diagnosisList() {
		List<DiagnosisDto> list;
		try {
			list = diaSvc.list();
			System.out.println("진료번호  의사id  환자id    진료일    진료내용");
			for (DiagnosisDto dto : list) {
				System.out.println(dto.getDiaId() + "        " + dto.getDoctorId() + "     " + dto.getpId() + "   "
						+ dto.getDiagnosisDate() + "   " + dto.getDiagnosisContents());

			}

		} catch (DiagnosisException e) {

			System.out.println("");

		}

	}

	private void diagnosisUpdate() {
		System.out.println("🩺 진료 정보 수정 🩺");
		System.out.println("수정하고 싶은 진료 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());

		try {

			System.out.println("** 진료 정보 수정 **");
			System.out.println("의사 ID를 입력하세요>> ");
			int doctorId = Integer.parseInt(sc.nextLine());
			System.out.println("환자 ID를 입력하세요>> ");
			int pId = Integer.parseInt(sc.nextLine());
			System.out.println("진료 변경 날짜를 입력하세요(yyyy-MM-dd) >> ");
			String str = sc.nextLine();
			Date diagnosisDate = Date.valueOf(str);
			System.out.println("진료 변경 내용을 입력하세요 >> ");
			String diagnosisContents = sc.nextLine();

			diaSvc.update(new DiagnosisDto(no, pId, doctorId, diagnosisDate, diagnosisContents));

			System.out.println("수정완료");

		} catch (DiagnosisException e) {
			e.printStackTrace();

		} catch (RecordNotFoundException e) {
			System.out.println("없는 진료입니다");

		}

	}

	private void diagnosisDelete() {

		System.out.println("🩺 진료 정보 삭제 🩺");
		System.out.println("삭제하고 싶은 진료 번호를 입력하세요 >> ");
		int no = Integer.parseInt(sc.nextLine());

		try {
			diaSvc.delete(no);

		} catch (DiagnosisException e) {
			System.out.println();

		} catch (RecordNotFoundException e) {
			System.out.println("없는 진료입니다");

		}

	}

	private void diagnosisCount() {

		try {
			System.out.println("진료수: " + diaSvc.count());
		} catch (DiagnosisException e) {
			System.out.println("서버에 오류가 발생했습니다");

		}
	}
}
