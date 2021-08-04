import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {

	static int N, M;
	static int[][] map;
	static int[][] tempMap;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, -1, 0, 1 };
	static boolean[][] visited = new boolean[N][M];

	static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			int count = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}

			if (count == 0) {
				System.out.print(0);
				break;
			} else if (count >= 2) {
				System.out.print(year);
				break;
			}

			iceberg();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = tempMap[i][j];
				}
			}

			year++;
		}
	}

	static void bfs(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Location now = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempX = now.x + offsetX[i];
				int tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M) {
					if (!visited[tempX][tempY] && map[tempX][tempY] != 0) {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}

	static void iceberg() {
		tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						if (map[i + offsetX[k]][j + offsetY[k]] == 0) {
							count++;
						}
					}
					tempMap[i][j] = Math.max(map[i][j] - count, 0);
				}
			}
		}
	}
}
