import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1644 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isNotPrime = new boolean[N + 1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i <= N; i++) {
			for (int j = i + i; j <= N; j += i) {
				if (!isNotPrime[j]) {
					isNotPrime[j] = true;
				}
			}
		}

		int sum = 0, left = 0, right = 0, answer = 0;
		while (left <= N && right <= N) {
			if (isNotPrime[left]) {
				left++;
				continue;
			}
			if (isNotPrime[right]) {
				right++;
				continue;
			}
			if (sum == N) {
				answer++;
				sum -= left;
				left++;
			} else if (sum > N) {
				sum -= left;
				left++;
			} else if (sum < N) {
				sum += right;
				right++;
			}
			if (right > N) {
				right = N;
			}
		}
		System.out.print(answer);
	}
}