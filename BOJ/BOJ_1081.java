import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1081 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());

		System.out.print(digitSum(U) - digitSum(L - 1));
	}

	static long digitSum(int num) {
		int start = 1;
		int end = num;
		int base = 1;

		long[] answer = new long[10];
		while (start <= end) {
			while (end % 10 != 9 && start <= end) {
				int temp = end;
				while (temp > 0) {
					answer[temp % 10] += base;
					temp /= 10;
				}
				end--;
			}

			if (end < start) {
				break;
			}

			while (start % 10 != 0 && start <= end) {
				int temp = start;
				while (temp > 0) {
					answer[temp % 10] += base;
					temp /= 10;
				}
				start++;
			}

			start /= 10;
			end /= 10;

			for (int i = 0; i < 10; i++) {
				answer[i] += (end - start + 1) * base;
			}

			base *= 10;
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += answer[i] * i;
		}
		return sum;
	}
}
