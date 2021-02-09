import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		int count = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 1;
		int check = 0;

		while (right <= N) {
			check = 0;
			for (int i = left; i <= right; i++) {
				check += arr[i];
			}
			if (check == M) {
				count++;
				right++;
			} else if (check < M) {
				right++;
			} else {
				left++;
			}
		}

		System.out.print(count);
	}
}
