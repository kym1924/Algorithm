import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663 {

	static int N, answer = 0;
	static int[] chess;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		nQueen(0);
		System.out.print(answer);
	}

	static void nQueen(int now) {
		if (now == N) {
			answer++;
		} else {
			for (int i = 0; i < N; i++) {
				chess[now] = i;
				if (check(now)) {
					nQueen(now + 1);
				}
			}
		}
	}

	static boolean check(int now) {
		for (int i = 0; i < now; i++) {
			if (chess[now] == chess[i] || Math.abs(chess[now] - chess[i]) == now - i) {
				return false;
			}
		}
		return true;
	}
}