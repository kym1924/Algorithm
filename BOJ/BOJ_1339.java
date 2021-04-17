import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] alphabet = new long[26];
		String[] numbers = new String[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = br.readLine();
			int radix = 1;
			for (int j = numbers[i].length() - 1; j >= 0; j--) {
				alphabet[numbers[i].charAt(j) - 'A'] += radix;
				radix *= 10;
			}
		}

		Arrays.sort(alphabet);

		long answer = 0;
		int value = 9;
		for (int i = 25; i >= 0; i--) {
			if (value == 0) {
				break;
			}
			answer += alphabet[i] * value--;
		}

		System.out.print(answer);
	}
}