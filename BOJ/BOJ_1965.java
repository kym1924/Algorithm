import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class BOJ_1965 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j <= i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		Arrays.sort(dp);
		System.out.print(dp[n - 1]);
	}
}
