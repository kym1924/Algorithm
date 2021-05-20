import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10476 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] room = new int[N + 1][2];

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				sum += room[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());

		if (K == 0) {
			System.out.print(sum);
			return;
		}

		int[][][] dp = new int[N + 1][K + 1][3];

		dp[1][1][0] = room[1][1];
		dp[1][1][1] = room[1][0];
		dp[1][0][2] = room[1][0] + room[1][1];

		for (int i = 2; i <= N; i++) {
			dp[i][0][2] = dp[i - 1][0][2] + room[i][0] + room[i][1];
			for (int j = 1; j <= K && j <= i; j++) {
				dp[i][j][0] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][2]) + room[i][1];
				dp[i][j][1] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + room[i][0];
				if (i != j) {
					dp[i][j][2] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + room[i][0]
							+ room[i][1];
				}
			}
		}
		System.out.print(Math.max(dp[N][K][0], Math.max(dp[N][K][1], dp[N][K][2])));
	}
}
