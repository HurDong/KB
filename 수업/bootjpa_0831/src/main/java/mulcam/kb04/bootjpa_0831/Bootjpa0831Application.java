package mulcam.kb04.bootjpa_0831;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import mulcam.kb04.bootjpa_0831.entity.Board;
import mulcam.kb04.bootjpa_0831.ifs.BoardRepository;

@SpringBootApplication
public class Bootjpa0831Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Bootjpa0831Application.class, args);
		Bootjpa0831Application bean = context.getBean(Bootjpa0831Application.class);
		bean.execute();
	}

	@Autowired
	BoardRepository repo;

	public void execute() {
		printAll();
	}

	private void printAll() {
		List<Board> list = repo.findAll();
		for (Board board : list) {
			System.out.println(board);
		}
	}

	private void insertBoard() {
		Board b = new Board();
		b.setTitle("boot로 등록");
		b.setWriter("boot01");
		b.setContent("boot로 등록해보았어요");
		b.setRegdate(new Date());
		repo.save(b);
		System.out.println("등록완료");
	}

	private void printCount() {
		long count = repo.count();
		System.out.println("count = " + count);

	}

}
