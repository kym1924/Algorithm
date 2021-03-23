import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1132 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long radix, answer = 0;
		int N = Integer.parseInt(br.readLine());
		boolean[] first = new boolean[10];
		long[] alphabet = new long[10];
		String[] numbers = new String[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = br.readLine();
			first[numbers[i].charAt(0) - 'A'] = true;
			radix = 1;
			for (int j = numbers[i].length() - 1; j >= 0; j--) {
				alphabet[numbers[i].charAt(j) - 'A'] += radix;
				radix *= 10;
			}
		}

		if (checkUsed(alphabet) == 10) {
			Long min = Long.MAX_VALUE;
			int minUnusedIndex = -1;
			for (int i = 0; i < 10; i++) {
				if (!first[i]) {
					if (min > alphabet[i]) {
						min = alphabet[i];
						minUnusedIndex = i;
					}
				}
			}
			alphabet[minUnusedIndex] = 0;
		}

		Arrays.sort(alphabet);

		for (int i = 0; i < 10; i++) {
			answer += alphabet[i] * i;
		}
		System.out.print(answer);
	}

	static int checkUsed(long[] used) {
		int checkUsed = 0;
		for (int i = 0; i < 10; i++) {
			if (used[i] != 0) {
				checkUsed++;
			}
		}
		return checkUsed;
	}
}