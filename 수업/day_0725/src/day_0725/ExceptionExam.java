package day_0725;

import java.io.FileNotFoundException;
import java.io.FileReader;
public class ExceptionExam {
	public static void main(String[] args) throws FileNotFoundException {
			readFile2();
			System.out.println("파일 처리 성공");
			System.err.println("파일 처리 실패");
	}

	private static void readFile() {
		try {
			FileReader fr = new FileReader("poem.txt"); // 현재 프로젝트 디렉토리
			System.out.println("파일있음");
		} catch (FileNotFoundException e) {
			System.out.println("파일없음");
			System.err.println("파일없음");
			e.printStackTrace();
		}
	}

	private static void readFile2() throws FileNotFoundException {
		FileReader fr = new FileReader("poem.txt"); // 현재 프로젝트 디렉토리
		System.out.println("파일있음");
	}
}
