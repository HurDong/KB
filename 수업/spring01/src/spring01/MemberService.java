package spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberService {
	@Autowired(required = false)
	@Qualifier("memberDao")
	private MemberDao dao = null;

	public boolean login(String id, String passwd) {
		System.out.println("dao=" + dao);
		return false;
	}
}
