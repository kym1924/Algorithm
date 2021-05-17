import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9184 {

	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String number;
		while (!(number = br.readLine()).equals("-1 -1 -1")) {
			String[] numbers = number.split(" ");
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int c = Integer.parseInt(numbers[2]);
			bw.write("w(" + a + ", " + b + ", " + c + ") =" + " " + w(a, b, c) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		if (dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
}