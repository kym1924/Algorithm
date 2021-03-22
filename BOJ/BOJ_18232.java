import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18232 {

	static int N, M, S, E;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> teleport = new ArrayList<>();

	static class Location {
		int location;
		int count;

		Location(int location, int count) {
			this.location = location;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			teleport.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			teleport.get(x).add(y);
		}
		bfs();
	}

	static void bfs() {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(S, 0));
		visited[S] = true;

		while (!q.isEmpty()) {
			Location now = q.poll();
			if (now.location == E) {
				System.out.print(now.count);
				return;
			}
			int prevX = now.location - 1;
			if (prevX > 0 && prevX <= N && !visited[prevX]) {
				visited[prevX] = true;
				q.add(new Location(prevX, now.count + 1));
			}
			int nextX = now.location + 1;
			if (nextX > 0 && nextX <= N && !visited[nextX]) {
				visited[nextX] = true;
				q.add(new Location(nextX, now.count + 1));
			}
			for (int i = 0; i < teleport.get(now.location).size(); i++) {
				int teleportX = teleport.get(now.location).get(i);
				if (!visited[teleportX]) {
					visited[teleportX] = true;
					q.add(new Location(teleportX, now.count + 1));
				}
			}
		}
	}
}