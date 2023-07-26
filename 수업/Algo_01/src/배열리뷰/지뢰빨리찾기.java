package 배열리뷰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 지뢰빨리찾기 {
	 /* 10X10 좌표에 10개 임의의 위치에 지뢰를 매설
     * 사용자는 행,열 좌표를 입력, (1~10, 1~10)
     * 해당 좌표가 지뢰이면 X표시. 아니면 주위 8칸내 지뢰갯수 표시
     * 열지 않은 좌표는 "+" 표시 
     * 
     * 1. 12X12 정수배열생성
     * 2. 중복되지 않는 10개 좌표 생성
     * 3. 각좌표에 9저장. 주위 8개에 1씩 증가
     * 4. (반복)
     * 5. 사용자로부터 좌표입력(행, 열)
     * 6. 해당좌표의 값이 9이상이면 "지뢰찾음" 출력
     * 7. 해당좌표가 9미만이면 "지뢰아님" 출력
     * 8. 전체배열 출력(+: 오픈 안한 좌표, 숫자: 지뢰아닌곳, X: 지뢰)
     * 9. 지뢰 10개를 다 찾으면 종료. 아니면 5번부터 반복
     * 
     */
	public static void main(String[] args) throws IOException {
		
		int[][] arr = new int[12][12];
		int a=0, b=0;
		System.out.println(a);
		int remainMines = 10;
		
		String[][] field = new String[12][12]; // 화면에 출력한 배열 생성
		
		int x,y;
		
		for(int i=0; i<10;) {
			x = (int) (Math.random()*10+1);
			y = (int) (Math.random()*10+1);		
			if(arr[x][y] == 0) {
				arr[x][y] = 9;
				System.out.println( "(" + x + "," + y + ") 지뢰 생성" );
				i++;
			}
			
		}
		
		System.out.println();
		
		x=0;
		y=0;
		
		int[][] temp = new int[12][12]; // 지뢰를 저장할 배열 생성
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				field[i][j] = "+";
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(remainMines > 0) {
			
			System.out.println("X 좌표와 Y 좌표를 입력하시오.");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if (temp[x][y] >= 9) {				
				field[x][y] = "x";
				remainMines--;
				System.out.println("지뢰를 찾았습니다. 남은 지뢰의 수 : " + remainMines);				
			}
			else {
				int count = 0;
				
				if(arr[x-1][y-1]>=9) count++;
				if(arr[x-1][y]>=9) count++;
				if(arr[x-1][y+1]>=9) count++;
				if(arr[x][y-1]>=9) count++;
				if(arr[x][y+1]>=9) count++;
				if(arr[x+1][y-1]>=9) count++;
				if(arr[x+1][y]>=9) count++;
				if(arr[x+1][y+1]>=9) count++;
				
				arr[x-1][y-1] = + count;
				arr[x-1][y] = + count;
				arr[x-1][y+1] = + count;
				arr[x][y-1] = + count;
				arr[x][y+1] = + count;
				arr[x+1][y-1] = + count;
				arr[x+1][y] = + count;
				arr[x+1][y+1] = + count;
				
				
				
				
				field[x-1][y-1] = Integer.toString(arr[x-1][y-1]);
				
				
				field[x-1][y] = Integer.toString(arr[x-1][y]);
				
				field[x-1][y+1] = Integer.toString(arr[x-1][y+1]);
				
				field[x][y-1] = Integer.toString(arr[x][y-1]);
				
				field[x][y+1] = Integer.toString(arr[x][y+1]);
				
				field[x+1][y-1] = Integer.toString(arr[x+1][y-1]);
				
				field[x+1][y] = Integer.toString(arr[x+1][y]);
				
				field[x+1][y+1] = Integer.toString(arr[x+1][y+1]);
				
				System.out.println("지뢰를 찾지 못하였습니다. 남은 지뢰의 수 : " + remainMines);
			}
			
			for (int i = 1; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					System.out.print(field[i][j] + " ");
				}
				System.out.println();
			}
			
//			System.out.println("* * * * * * * * * * * *");
			
//			for (int i = 0; i < 12; i++) {
//				for (int j = 0; j < 12; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			
		}
		
		System.out.println("지뢰를 모두 찾았습니다.");
		
	}	
}
