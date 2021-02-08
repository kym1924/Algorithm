import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_1012 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] offsetX = { 1, 0, -1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };
	static Queue<Location> q = new LinkedList<>();

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + 1][M + 1];
			visited = new boolean[N + 1][M + 1];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			int count = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (!visited[j][k] && map[j][k] == 1) {
						count++;
						bfs(j, k);
						// dfs(j, k);
					}
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int tempX = x + offsetX[i];
			int tempY = y + offsetY[i];
			if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M) {
				if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
					dfs(tempX, tempY);
				}
			}
		}
	}

	static void bfs(int x, int y) {
		visited[x][y] = true;
		q.add(new Location(x, y));

		while (!q.isEmpty()) {
			Location now = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempX = now.x + offsetX[i];
				int tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}
}
