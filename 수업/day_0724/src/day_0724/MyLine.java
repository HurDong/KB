package day_0724;

/** 선 */
public class MyLine extends MyShape {

	private int x2, y2;

	// 생성자2개
	public MyLine() {
	}

	public MyLine(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return super.toString() + ", x2=" + x2 + ", y2=" + y2 + "]";
	}

	@Override
	public String draw() {
		return "LINE";
	}
}