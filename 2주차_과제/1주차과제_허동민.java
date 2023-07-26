package HW2; // HW2 패키지

import java.io.BufferedReader; // 입력을 받기 위한 import
import java.io.IOException; // 예외처리를 위한 import
import java.io.InputStreamReader; // 입력을 받기 위한 import
import java.util.StringTokenizer; // 입력을 받기 위한 import

public class 일주차과제_허동민 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferReader 타입의 br 선언
		StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer 타입의 st 선언 후 입력 한 줄 받음.

		int n = Integer.parseInt(st.nextToken()); // 사용자의 입력을 받아 n에 저장
		int m = Integer.parseInt(st.nextToken()); // 사용자의 입력을 받아 m에 저장

		st = new StringTokenizer(br.readLine()); // 새로운 입력 한 줄을 받음.

		long count = 0; // 답안으로 출력할 구간의 개수를 저장할 count 변수 선언

		long[] sum = new long[n]; // 구간의 누적합을 저장할 sum 배열 선언
		sum[0] = Integer.parseInt(st.nextToken()); // 사용자 입력의 두번째 줄의 첫번째 입력을 sum[0]에 먼저 저장
		for (int i = 1; i < n; i++) { 
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken()); // sum[1] ~ sum[n-1]를 입력받은 값과 sum[i-1] 의 합으로 저장
		}

		long[] rem = new long[m]; // sum 배열을 m으로 나누었을 때의 나머지를 0 ~ m-1 값마다 저장할 배열 rem을 생성
		for (int i = 0; i < n; i++) {
			int remainder = (int) (sum[i] % m); // remainder 변수를 sum[i]%m으로 나타내어 나머지가 0인지 아닌지를 확인
			if (remainder == 0) {
				count++; // remainder가 0이라면 count 변수를 증가
			}
			rem[remainder]++; // remainder 나머지에 해당하는 배열을 찾아 해당 배열의 값을 증가

		}

		for (int i = 0; i < m; i++) {
			if (rem[i] > 1) { // rem 배열에서 rem[i]가 1이 넘을 경우
				count = count + (rem[i] * (rem[i] - 1) / 2); // count 변수에 기존 count 값과 1 ~ rem[i]-1 값까지의 값을 더한 값을 더해줌. 
			}

		}

		System.out.println(count); // 답안인 count 변수를 출력

	}
}
