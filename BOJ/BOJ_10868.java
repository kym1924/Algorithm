import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10868 {

	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new long[N];
		tree = new long[4 * N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		init(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(find(1, 0, N - 1, a - 1, b - 1)) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			return tree[node] = Math.min(init(node * 2, start, (start + end) / 2),
					init(node * 2 + 1, (start + end) / 2 + 1, end));
		}
	}

	static long find(int node, int start, int end, int left, long right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return Math.min(find(node * 2, start, (start + end) / 2, left, right),
				find(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}
}
