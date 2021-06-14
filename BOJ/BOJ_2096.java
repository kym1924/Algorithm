import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
	static int[][] maxDp = new int[2][3];
	static int[][] minDp = new int[2][3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			maxDp[0][i] = minDp[0][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			dp(i, zero, one, two);
		}
		result(N);
	}

	static void dp(int i, int zero, int one, int two) {
		int now = i % 2, prev = (i - 1) % 2;
		maxDp[now][0] = Math.max(maxDp[prev][0], maxDp[prev][1]) + zero;
		minDp[now][0] = Math.min(minDp[prev][0], minDp[prev][1]) + zero;
		maxDp[now][1] = Math.max(maxDp[prev][0], Math.max(maxDp[prev][1], maxDp[prev][2])) + one;
		minDp[now][1] = Math.min(minDp[prev][0], Math.min(minDp[prev][1], minDp[prev][2])) + one;
		maxDp[now][2] = Math.max(maxDp[prev][1], maxDp[prev][2]) + two;
		minDp[now][2] = Math.min(minDp[prev][1], minDp[prev][2]) + two;
	}

	static void result(int N) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int index = (N - 1) % 2;
		max = Math.max(maxDp[index][0], Math.max(maxDp[index][1], maxDp[index][2]));
		min = Math.min(minDp[index][0], Math.min(minDp[index][1], minDp[index][2]));
		System.out.print(max + " " + min);
	}
}
