import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2023 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.print(2 + "\n" + 3 + "\n" + 5 + "\n" + 7);
		} else {
			dfs(2, 2);
			dfs(3, 2);
			dfs(5, 2);
			dfs(7, 2);
		}
	}

	public static void dfs(int num, int n) {
		for (int i = 1; i <= 9; i++) {
			int temp = num * 10 + i;
			if (isPrime(temp)) {
				if (n == N) {
					System.out.println(temp);
				} else {
					dfs(temp, n + 1);
				}
			}
		}
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}
