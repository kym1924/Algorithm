import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2357 {

	static long[] arr;
	static long[] minTree;
	static long[] maxTree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new long[N];
		minTree = new long[4 * N];
		maxTree = new long[4 * N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		minInit(1, 0, N - 1);
		maxInit(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(minFind(1, 0, N - 1, a - 1, b - 1)) + " ");
			bw.write(String.valueOf(maxFind(1, 0, N - 1, a - 1, b - 1)) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static long minInit(int node, int start, int end) {
		if (start == end) {
			return minTree[node] = arr[start];
		} else {
			return minTree[node] = Math.min(minInit(node * 2, start, (start + end) / 2),
					minInit(node * 2 + 1, (start + end) / 2 + 1, end));
		}
	}

	static long maxInit(int node, int start, int end) {
		if (start == end) {
			return maxTree[node] = arr[start];
		} else {
			return maxTree[node] = Math.max(maxInit(node * 2, start, (start + end) / 2),
					maxInit(node * 2 + 1, (start + end) / 2 + 1, end));
		}
	}

	static long minFind(int node, int start, int end, int left, long right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return minTree[node];
		}
		return Math.min(minFind(node * 2, start, (start + end) / 2, left, right),
				minFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}

	static long maxFind(int node, int start, int end, int left, long right) {
		if (left > end || right < start) {
			return Integer.MIN_VALUE;
		}
		if (left <= start && end <= right) {
			return maxTree[node];
		}
		return Math.max(maxFind(node * 2, start, (start + end) / 2, left, right),
				maxFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}
}
