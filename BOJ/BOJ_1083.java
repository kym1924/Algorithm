import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1083 {

	static int N, S;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		S = Integer.parseInt(br.readLine());

		for (int i = 0; i < N && S > 0; i++) {
			int max = A[i];
			int index = i;
			for (int j = i + 1; j <= i + S && j < N; j++) {
				if (max < A[j]) {
					max = A[j];
					index = j;
				}
			}
			sort(max, i, index);
		}

		for (int i = 0; i < N; i++) {
			System.out.print(A[i] + " ");
		}
	}

	static void sort(int max, int start, int end) {
		for (int i = end; i > start; i--) {
			A[i] = A[i - 1];
			S--;
		}
		A[start] = max;
	}
}