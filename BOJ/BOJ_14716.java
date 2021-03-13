import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14716 {
	static int M, N;
	static int[][] map;
	static int[] offsetX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] offsetY = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean[][] visited;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					answer++;
					bfs(i, j);
				}
			}
		}
		System.out.print(answer);
	}

	static void bfs(int x, int y) {
		visited[x][y] = true;
		q.add(new Location(x, y));

		while (!q.isEmpty()) {
			Location now = q.poll();
			for (int i = 0; i < 8; i++) {
				int tempX = now.x + offsetX[i];
				int tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < M && tempY >= 0 && tempY < N) {
					if (map[tempX][tempY] == 1 && !visited[tempX][tempY]) {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}
}
