package spring01;

import java.util.List;

import spring01.dto.MemberDto;

public interface MemberDao {
	public void add(MemberDto dto) {
	}

	public List<MemberDto> list(){
	}

	public MemberDto findById(String id) {
	}
}
