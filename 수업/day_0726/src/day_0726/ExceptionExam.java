package day_0726;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExam {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("poem.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println("\n파일 읽기 종료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("파일 없음");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("입출력 오류");
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
			}
		}
	}
}
