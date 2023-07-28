package workshop;

import java.util.ArrayList;

public class LibraryService {
	private ArrayList<개인회원> memList = new ArrayList<개인회원>();
	private ArrayList<MyItem> itemList = new ArrayList<MyItem>();
	private ArrayList<MyRent> rentList = new ArrayList<MyRent>();

	public void add(개인회원 mem) throws 회원아이디중복Exception {
		for (개인회원 회원 : memList) {
			if(회원.getId().equals(mem.getId()))
				throw new 회원아이디중복Exception("중복ID: "+회원.getId());
		}
		memList.add(mem);
	}
	public void add(MyItem item) {
		for (MyItem myItem : itemList) {
			//같은 물건이 있으면 수량증가
			if(myItem.getItemNo() == item.getItemNo()) {
				int tot = myItem.getQuantity()+item.getQuantity();
				myItem.setQuantity(tot);
				return;
			}
		}//end for
		itemList.add(item);
	}
	public void rent( int 대여물건id, String 대여자id, String 대여날짜,
			int 대여시, int 대여분, int 수량) throws 미등록물건Exception, 미등록회원idException, 수량부족Exception {
		MyItem item = findItemById(대여물건id);
		if(item == null )
			throw new 미등록물건Exception();
		개인회원 g = findMemberById(대여자id);
		if(g == null) 
			throw new 미등록회원idException();
		if(item.getQuantity() == 0)
			throw new 수량부족Exception();
		//현재시간 / 1000
		int 대여관리번호 = (int)System.currentTimeMillis()/1000;
		MyRent rent = new MyRent(대여관리번호, g.getId(), item.getItemNo(), 
				대여날짜, 대여시, 대여분, null, -1, 1);
		int q = item.getQuantity();
		item.setQuantity(q-1);//수량1감소
		rentList.add(rent);
		
	}
	public 개인회원 findMemberById(String 대여자id) {
		for (개인회원 g : memList) {
			if(g.getId() == g.getId())
				return g;
		}
		return null;
	}
	public MyItem findItemById(int 대여물건id) {
		for (MyItem myItem : itemList) {
			if(myItem.getItemNo() == 대여물건id)
				return myItem;
		}
		return null;
	}
	public ArrayList<개인회원> findMemberByName(String name) {
		ArrayList<개인회원> result = new ArrayList<개인회원>();
		for (개인회원 g : result) {
			if(g.getName().equals(name))
				result.add(g);
		}
		return result;
	}
	public MyItem findItemByTitle(String title) {
		for (MyItem myItem : itemList) {
			if(myItem.getTitle().equals(title))
				return myItem;
		}
		return null;
	}
	public void returnItem(int itemNo, String userid, String 반납날짜, 
									int 반납시, int 반납분, int 수량) throws 미등록물건Exception, 미등록회원idException, 수량부족Exception {
		MyItem item = findItemById(itemNo);
		if(item == null )
			throw new 미등록물건Exception();
		개인회원 g = findMemberById(userid);
		if(g == null) 
			throw new 미등록회원idException();
		if(item.getQuantity() == 0)
			throw new 수량부족Exception();
		//대여목록에서 대여정보 검색
		for (MyRent myRent : rentList) {
			if(myRent.get회원id().equals(userid) && 
					myRent.get대여물건관리번호() == itemNo ) {
				myRent.set반납년월일(반납날짜);
				myRent.set반납시(반납시);
				myRent.set반납분(반납분);
				//대여물건의 수량 1증가
				int q = item.getQuantity();
				item.setQuantity(q+1);
			}
		}
	}
}



