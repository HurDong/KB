package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import mybatis.dto.BoardDto;

@Mapper
public interface BoardMapper {
	@Select("select count(*) from board")
	public int count();

	@Select("select * from board order by no desc")
	public List<BoardDto> list();

	@Select("select * from board where no = #{no}")
	public BoardDto findByNo(int no);

	@Insert("insert into board (no, title, writer, content, regdate) values (board_seq.nextval,#{title},#{writer},#{content},sysdate)")
	public int insert(BoardDto dto);

}
