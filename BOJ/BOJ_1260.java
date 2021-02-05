import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static int N, M, V;
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			edge.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edge.get(from).add(to);
			edge.get(to).add(from);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(edge.get(i));
		}

		dfs(V);

		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}

		sb.append("\n");

		bfs();
	}

	static void dfs(int start) {
		sb.append(start + " ");
		visited[start] = true;
		for (int i = 0; i < edge.get(start).size(); i++) {
			int next = edge.get(start).get(i);
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs() {
		q.add(V);
		visited[V] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");
			for (int i = 0; i < edge.get(now).size(); i++) {
				int next = edge.get(now).get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		System.out.print(sb.toString());
	}
}