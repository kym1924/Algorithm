import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2042 {

	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new long[N];
		tree = new long[4 * N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		init(1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long diff = c - arr[b - 1];
				arr[b - 1] = c;
				update(1, 0, N - 1, b - 1, diff);
			} else if (a == 2) {
				bw.write(String.valueOf(sum(1, 0, N - 1, b - 1, c - 1)) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			return tree[node] = init(node * 2, start, (start + end) / 2)
					+ init(node * 2 + 1, (start + end) / 2 + 1, end);
		}
	}

	static long sum(int node, int start, int end, int left, long right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return sum(node * 2, start, (start + end) / 2, left, right)
				+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	static void update(int node, int start, int end, int index, long diff) {
		if (index < start || index > end) {
			return;
		}
		tree[node] += diff;
		if (start != end) {
			update(node * 2, start, (start + end) / 2, index, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}
	}
}
