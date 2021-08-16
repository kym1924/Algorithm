import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1990 {

	static boolean[] isPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (b > 10000000) {
			b = 10000000;
		}

		isPrime = new boolean[b + 1];
		isPrime(b);
		for (int i = a; i <= b; i++) {
			if (!isPrime[i]) {
				if (isPalindrome(i)) {
					bw.write(i + "\n");
				}
			}
		}
		bw.write(String.valueOf(-1));
		bw.flush();
		bw.close();
	}

	public static void isPrime(int b) {
		for (int i = 2; i <= b; i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i + i; j <= b; j += i) {
				isPrime[j] = true;
			}
		}
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
