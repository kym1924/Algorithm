import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, check = 0;
		int min = Integer.MAX_VALUE;

		while (right <= N) {
			if (check >= S) {
				min = Math.min(min, right - left);
				check -= arr[left++];
			} else if (check < S) {
				check += arr[right++];
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.print(0);
		} else {
			System.out.print(min);
		}
	}
}
