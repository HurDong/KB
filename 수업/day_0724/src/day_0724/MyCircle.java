package day_0724;

public class MyCircle extends MyShape {

	private int radius;

	public MyCircle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public String draw() {
		return "CIRCLE";
	}

	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}
}