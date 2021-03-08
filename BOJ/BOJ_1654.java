import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] length = new int[K];
		for (int i = 0; i < K; i++) {
			length[i] = Integer.parseInt(br.readLine());
		}

		long left = 0;
		long right = Long.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;
			int result = 0;
			for (int i = 0; i < K; i++) {
				result += length[i] / mid;
			}
			if (result < N) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.print(right);
	}
}