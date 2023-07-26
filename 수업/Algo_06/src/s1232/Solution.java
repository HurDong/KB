package s1232;

public class Solution {
	static class Node {
		int value;// 노드값
		char opr; // 연산자
		int left, right;// 자식도느반환
		public Node(int value, char opr, int left, int right) {
			super();
			this.value = value;
			this.opr = opr;
			this.left = left;
			this.right = right;
		}
		
		public Node(int i) {
			this(i,null,null,null);
		}

		public Node(int i, Object object, Object object2, Object object3) {
			// TODO Auto-generated constructor stub
		}
	}
	
	static int N; // 노드갯수
	static int result; // 계산 결과
	static Node[] nodes; //

	public static void main(String[] args) {
		N = 5;
		nodes = new Node[N + 1];
		nodes[1] = new Node(0,'-',2,3);
		nodes[2] = new Node(0,'-',4,5);
		nodes[3] = new Node(10);
		nodes[4] = new Node(88);
		nodes[5] = new Node(65);
		
		int answer = calc(nodes[1]);
		System.out.println(answer);
	}

	private static int calc(Node node) {
		// 연산자 추출
		char opr = node.opr;
		if(opr=='-') {
			return calc(nodes[node.left])-calc(nodes[node.right]);
		}
		else if(opr=='+') {
			return nodes[node.left].value + nodes[node.right].value;
		}
		else {
			return node.value;
		}
	}
}
