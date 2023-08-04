package day_0802;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import day_0802.dao.BoardDao;
import day_0802.dao.DuplicatedIdException;
import day_0802.dao.RecordNotFoundException;
import day_0802.util.JdbcUtil;
import day_0802.vo.BoardDto;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException {
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "insert into board (no,title,writer,content,regdate)";
			sql += "values( board_seq.nextval , ? , ? , ?, sysdate )";

			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);

			// 5. 데이터 설정
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());

			// 6. SQL 전송 및 결과 수신
			// DML전송 : executeUpdate() : int
			// SELECT전송 : executeQuery() : ResultSet
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException {
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "update board set title = ?, writer = ? ,  content = ? where no = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);

			// 5. 데이터 설정
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNo());
			// 6. SQL 전송 및 결과 수신
			// DML전송 : executeUpdate() : int
			// SELECT전송 : executeQuery() : ResultSet
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void delete(BoardDto dto) throws SQLException, RecordNotFoundException {
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "delete from board where no = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);

			// 5. 데이터 설정
			pstmt.setInt(1, dto.getNo());
			// 6. SQL 전송 및 결과 수신
			// DML전송 : executeUpdate() : int
			// SELECT전송 : executeQuery() : ResultSet
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void count() throws SQLException {
	}

	@Override
	public List<BoardDto> list() throws SQLException {
		List<BoardDto> result = new ArrayList<BoardDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			String sql = "select * from board order by no desc";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				String content = rs.getString("content");
				BoardDto dto = new BoardDto(no, title, writer, regdate, content);
				result.add(dto);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return result;
	}

	@Override
	public BoardDto findById(int no) throws SQLException {
		BoardDto dto = null;
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM board WHERE no = ? "; // 띄워써야 함
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, no);
			// 6. SQL 전송, 결과수신
			// DML 전송: executeUpdate() : int
			// SELECT전송: executeQuery() : ResultSet
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 조회결과가 있다.
				// name은 PK이기때문에 있으면 한개라 IF
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				String content = rs.getString("content");
				dto = new BoardDto(no, title, writer, regdate, content);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}

		return dto;
	}

}
