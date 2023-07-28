package day_0726;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionExam2 {
	public static void main(String[] args) {
		try {
			readFile();
			System.out.println("파일 처리 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("파일 처리 실패");
		}
	}

	public static void readFile() throws IOException {
		FileReader fr = null;
		try {
			fr = null;
			fr = new FileReader("poem.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println("\n파일 읽기 종료");
		} finally {
			if (fr != null)
				fr.close();
		}
	}
}
