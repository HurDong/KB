package Stack;

import Stack.IntStack.EmptyIntStackException;

public class IntStack {
	public class EmptyIntStackException extends RuntimeException {
		public  EmptyIntStackException() {}
	}

	private int[] stk;
	private int capacity; // 최대 저장 갯수
	private int ptr = 0; // 현재 저장할 위치(현재저장갯수)
	
	public IntStack(int len) {
		stk = new int[len];
		capacity = len;
	}

	public IntStack() {
		this(64); // 내부 변수에 대한 접근을 일원화시킬 수 있음.	
	}

	public boolean push(int i) { // 원래는 exception 클래스로 예외처리 해주는게 좋음.
		if(ptr == capacity)
			return false;
		stk[ptr++] = 1;
		return true;
	}

	public int pop() {
		if(ptr == 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	

}
