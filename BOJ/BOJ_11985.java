import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11985 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] orange = new long[N + 1];
		long[] dp = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			orange[i] = Long.parseLong(br.readLine());
			dp[i] = K * (long) i;
		}

		for (int i = 2; i <= N; i++) {
			long min = orange[i];
			long max = orange[i];
			for (int j = 1; j <= M && i - j >= 0; j++) {
				min = Math.min(min, orange[i - j + 1]);
				max = Math.max(max, orange[i - j + 1]);
				dp[i] = Math.min(dp[i], dp[i - j] + K + j * (max - min));
			}
		}
		System.out.print(dp[N]);
	}
}
