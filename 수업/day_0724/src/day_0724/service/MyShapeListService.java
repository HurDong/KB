package day_0724.service;

import java.util.ArrayList;

import day_0724.MyLine;
import day_0724.MyShape;

public class MyShapeListService {
	private ArrayList<MyShape> shapes = new ArrayList<MyShape>();

	public void add(MyShape ms) {
		shapes.add(ms);
	}

	public int getCount() {
		return shapes.size();
	}

	public MyShape findByPosition(int startX, int startY) {
		for (MyShape myShape : shapes) {
			if (myShape.getX() == startX && myShape.getY() == startY) {
				return myShape;
			}
		}

		return null;
	}

}