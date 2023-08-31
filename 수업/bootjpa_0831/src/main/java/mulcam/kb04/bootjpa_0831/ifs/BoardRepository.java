package mulcam.kb04.bootjpa_0831.ifs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mulcam.kb04.bootjpa_0831.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
}
