import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {

	static int N, M, K, X;
	static int[] distinct;
	static ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		distinct = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			distinct[i] = -1;
			edge.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edge.get(from).add(to);
		}

		q.add(X);
		distinct[X]++;

		bfs();
		result();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int currentFrom = q.poll();
			for (int i = 0; i < edge.get(currentFrom).size(); i++) {
				int currentTo = edge.get(currentFrom).get(i);
				if (distinct[currentTo] == -1) {
					distinct[currentTo] = distinct[currentFrom] + 1;
					q.add(currentTo);
				}
			}
		}
	}

	static void result() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < N + 1; i++) {
			if (distinct[i] == K) {
				result.add(i);
			}
		}

		if (result.size() == 0) {
			System.out.print(-1);
		} else {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}
}
