import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_15558 {

	static int N, k;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Move> q = new LinkedList<>();

	static class Move {
		int line;
		int x;
		int time;

		Move(int line, int x, int time) {
			this.line = line;
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);

		map = new int[2][N];
		visited = new boolean[2][N];

		for (int i = 0; i < 2; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		System.out.print(bfs());
	}

	static int bfs() {
		visited[0][0] = true;
		q.add(new Move(0, 0, 0));

		while (!q.isEmpty()) {
			Move now = q.poll();

			if (now.x + 1 >= N) {
				return 1;
			} else if (!visited[now.line][now.x + 1] && map[now.line][now.x + 1] == 1) {
				visited[now.line][now.x + 1] = true;
				q.add(new Move(now.line, now.x + 1, now.time + 1));
			}

			if (now.x + k >= N) {
				return 1;
			} else if (!visited[1 - now.line][now.x + k] && map[1 - now.line][now.x + k] == 1) {
				visited[1 - now.line][now.x + k] = true;
				q.add(new Move(1 - now.line, now.x + k, now.time + 1));
			}

			if (now.x - 1 > 0) {
				if (!visited[now.line][now.x - 1] && map[now.line][now.x - 1] == 1 && now.x - 1 > now.time) {
					visited[now.line][now.x - 1] = true;
					q.add(new Move(now.line, now.x - 1, now.time + 1));
				}
			}
		}
		return 0;
	}
}
