package day_05;

import java.util.Comparator;

/** 이름 기준 정렬기 */
public class NameComparator implements Comparator<MyMember>{

	@Override
	public int compare(MyMember o1, MyMember o2) {
		
		return o2.getName().compareTo(o1.getName()); // 이름 기준 오름차순 정렬
	}
	
}
