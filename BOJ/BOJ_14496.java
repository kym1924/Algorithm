import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14496 {

	static int a, b, N, M;
	static boolean[][] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Queue<Now> q = new LinkedList<>();

	static class Now {
		int character;
		int count;

		Now(int now, int count) {
			this.character = now;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}

		System.out.print(bfs());
	}

	static int bfs() {
		q.add(new Now(a, 0));

		while (!q.isEmpty()) {
			Now now = q.poll();
			int count = now.count;

			if (now.character == b) {
				return count;
			}

			for (int i = 0; i < list.get(now.character).size(); i++) {
				int next = list.get(now.character).get(i);
				if (!visited[now.character][next]) {
					visited[now.character][next] = true;
					q.add(new Now(next, count + 1));
				}
			}
		}

		return -1;
	}
}
