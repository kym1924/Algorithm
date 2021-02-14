import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1747 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.print(2);
			return;
		}

		for (int i = N; i <= 1500000; i++) {
			if (isPalindrome(i)) {
				if (isPrime(i)) {
					System.out.print(i);
					break;
				}
			}
		}
	}

	public static boolean isPrime(int N) {
		for (int i = 2; i < N / 2; i++) {
			if (N % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome(int N) {
		StringBuilder str = new StringBuilder();
		str.append(N);
		if (str.toString().equals(str.reverse().toString())) {
			return true;
		}
		return false;
	}
}
