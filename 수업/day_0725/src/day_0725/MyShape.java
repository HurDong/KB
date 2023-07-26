package day_0725;

/** 도형들의 공통 속성 정의 */
public class MyShape {
	private int x, y;// 도형 기준 좌표

	public MyShape() {
		// TODO Auto-generated constructor stub
	}

	public MyShape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// 도형 그리기 기능 제공 -> 강제로 자식 클래스에서 정의하도록 유도
	public String draw() {
		return "drawing";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("x=").append(x).append(", y=").append(y);
		return builder.toString();
	}

}
