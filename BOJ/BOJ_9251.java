import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int[][] dp = new int[B.length() + 1][A.length() + 1];

		for (int i = 1; i <= B.length(); i++) {
			char b = B.charAt(i - 1);
			for (int j = 1; j <= A.length(); j++) {
				char a = A.charAt(j - 1);
				if (a == b) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.print(dp[B.length()][A.length()]);
	}
}
