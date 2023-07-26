package day_0724.service;

/** MyShape 파생객체를 저장 */

import day_0724.MyCircle;
import day_0724.MyLine;
import day_0724.MyShape;

public class MyShapeService {
	private MyShape[] lines = new MyShape[100];
	private int count = 0;// 저장될 위치, 저장갯수

	public void add(MyLine ml) {
		lines[count++] = ml;
	}

	public void add(MyCircle ml) {
		lines[count++] = ml;
	}

	public void add(MyShape ml) {
		lines[count++] = ml;
	}

	public int getCount() {
		return count;
	}

	public MyShape findByPosition(int startX, int startY) {
		// 0~count까지만 (실제 저장 마지막 위치)
		for (int i = 0; i < count; i++) {
			MyShape myShape = lines[i];
			if (myShape.getX() == startX && myShape.getY() == startY) {
				return myShape;
			}
		}
		return null; // 못찾으면 null변환
	}

}