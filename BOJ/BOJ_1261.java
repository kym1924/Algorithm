import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1261 {

	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, -1, 0, 1 };

	static class Location {
		int x;
		int y;
		int wall;

		Location(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		bfs();
	}

	static void bfs() {
		Deque<Location> dq = new ArrayDeque<>();
		visited[0][0] = true;
		dq.add(new Location(0, 0, 0));

		while (!dq.isEmpty()) {
			Location now = dq.poll();
			int tempX = now.x;
			int tempY = now.y;
			if (tempX == N - 1 && tempY == M - 1) {
				System.out.print(now.wall);
				return;
			}
			for (int i = 0; i < 4; i++) {
				tempX = now.x + offsetX[i];
				tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M) {
					if (!visited[tempX][tempY]) {
						visited[tempX][tempY] = true;
						if (map[tempX][tempY] == 1) {
							dq.addLast(new Location(tempX, tempY, now.wall + 1));
						} else if (map[tempX][tempY] == 0) {
							dq.addFirst(new Location(tempX, tempY, now.wall));
						}
					}
				}
			}
		}
	}
}
