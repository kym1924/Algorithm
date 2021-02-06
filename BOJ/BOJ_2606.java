import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2606 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

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

		bfs();
		System.out.print(result);
	}

	static void bfs() {
		q.add(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < edge.get(now).size(); i++) {
				if (!visited[edge.get(now).get(i)]) {
					visited[edge.get(now).get(i)] = true;
					result++;
					q.add(edge.get(now).get(i));
				}
			}
		}
	}
}
