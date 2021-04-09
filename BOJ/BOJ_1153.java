import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1153 {

	static boolean[] isNotPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		if (N < 8) {
			System.out.print(-1);
			return;
		}

		isNotPrime = new boolean[N + 1];
		initPrime(N);

		int temp = N;
		int count = 0;
		int sum = 0;
		while (count < 4) {
			for (int i = temp; i >= 2; i--) {
				if (!isNotPrime[i]) {
					if (i + ((4 - count - 1) * 2) <= N - sum) {
						count++;
						temp = i;
						sum += i;
						bw.write(String.valueOf(i) + " ");
						break;
					}
				}
			}
		}
		bw.flush();
		bw.close();
	}

	static void initPrime(int N) {
		for (int i = 2; i <= N; i++) {
			for (int j = i + i; j <= N; j += i) {
				if (!isNotPrime[j]) {
					isNotPrime[j] = true;
				}
			}
		}
	}
}
