import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] glass = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			glass[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.print(glass[1]);
			return;
		}

		int[] dp = new int[n + 1];
		dp[1] = glass[1];
		dp[2] = glass[1] + glass[2];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glass[i], dp[i - 3] + glass[i - 1] + glass[i]));
		}
		System.out.print(dp[n]);
	}
}
