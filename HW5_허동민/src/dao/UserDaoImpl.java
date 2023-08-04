package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.UserDto;

// 아래 각 메소드를 구현하세요.
public class UserDaoImpl implements UserDao {
	static int count = 0;

	@Override
	public int insertUser(UserDto userDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "insert into userdto(userseq,name,email,phone,issleep) ";
			sql += "values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userDto.getUserSeq());
			pstmt.setString(2, userDto.getName());
			pstmt.setString(3, userDto.getEmail());
			pstmt.setString(4, userDto.getPhone());
			String c = userDto.isSleep() ? "T" : "F";
			pstmt.setString(5, String.valueOf(c));
			count = pstmt.executeUpdate();
			DBManager.releaseConnection(pstmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateUser(UserDto userDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "update userdto set email = ? , phone = ? , issleep = ? where userseq = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userDto.getEmail());
			pstmt.setString(2, userDto.getPhone());
			String c = userDto.isSleep() ? "T" : "F";
			pstmt.setString(3, String.valueOf(c));
			pstmt.setInt(4, userDto.getUserSeq());
			count = pstmt.executeUpdate();
			DBManager.releaseConnection(pstmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteUser(int userSeq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "delete userdto where userseq = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userSeq);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<UserDto> selectAll() {
		List<UserDto> list = new ArrayList<UserDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM userdto";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDto user = new UserDto();
				user.setUserSeq(rs.getInt("userseq"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setSleep(rs.getString("issleep").equals("T") ? true : false);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return list;
	}

	@Override
	public UserDto selectOne(int userSeq) {
		UserDto user = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM userdto WHERE userseq = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userSeq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new UserDto();
				user.setUserSeq(rs.getInt("userseq"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setSleep(rs.getString("issleep").equals("T") ? true : false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return user;
	}

}
