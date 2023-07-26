//중복배제
package 집합;

public class 경우의수4_부분집합 {
    static int[] arr ; //원소
    static boolean[] visited;//사용여부
    static int n ; //답의 길이
    static int[] result; //답저장배열
    
    public static void main(String[] args) {
        arr = new int[]{1, 2, 3};
        n = 3;
        visited = new boolean[n];
        powerSet(0);
//        bit();
    }

    static void powerSet(int depth) {
        if (depth == n) {
            printResult();
            return;
        }

        visited[depth] = false;
        powerSet(depth + 1);

        visited[depth] = true;
        powerSet(depth + 1);
    }

    static void bit() {
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0)
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static void printResult() {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}