package day_04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionExam {
	public static void main(String[] args) {
		// 로또번호 생성기
		// List 타입 : int[]
		ArrayList<Integer> lottoList = new ArrayList<Integer>();
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		
		for (int i = 0; i < 6; i++) {
			int r = (int)(Math.random()*45 + 1 );
			lottoSet.add(r);
//			if(lottoList.contains(r)) {
//				i--;
//				continue;
//			}
			lottoList.add(r);
			
		}
		
		System.out.println(lottoList);
		System.out.println(lottoSet);
		System.out.println(lottoList.get(0));
		System.out.println(lottoList.size());
		System.out.println(lottoSet.size());
		
		
	}
}
