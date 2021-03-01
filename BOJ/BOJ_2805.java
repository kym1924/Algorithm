import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long[] tree = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(tree);

		long left = 1;
		long right = tree[n - 1];
		long mid = 0;

		while (right >= left) {
			mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < n; i++) {
				if (tree[i] - mid > 0) {
					sum += tree[i] - mid;
				}
			}
			if (sum >= m) {
				left = mid + 1;
			} else if (sum < m) {
				right = mid - 1;
			}
		}
		
		System.out.print(right);
	}
}
