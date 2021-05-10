import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11057 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.print(10);
			return;
		} else {
			int[][] dp = new int[N][10];

			for (int i = 0; i < 10; i++) {
				dp[0][i] = 1;
			}

			for (int i = 1; i < N; i++) {
				for (int j = 0; j < 10; j++) {
					for (int k = j; k >= 0; k--) {
						dp[i][j] += (dp[i - 1][k] % 10007);
					}
				}
			}
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += dp[N - 1][i];
			}
			System.out.print(sum % 10007);
		}
	}
}
