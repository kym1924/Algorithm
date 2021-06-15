import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2688 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[10];
			Arrays.fill(dp, 1);

			for (int j = 0; j < n - 1; j++) {
				for (int k = 1; k < 10; k++) {
					dp[k] += dp[k - 1];
				}
			}

			long result = 0;
			for (int j = 0; j < 10; j++) {
				result += dp[j];
			}
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}