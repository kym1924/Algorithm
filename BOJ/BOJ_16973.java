import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16973 {

	static int N, M;
	static int H, W, sR, sC, fR, fC;
	static int result = -1;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Location> q = new LinkedList<>();
	static int[] offsetX = { 1, 0, -1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };

	static class Location {
		int x;
		int y;
		int count;

		Location(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		sR = Integer.parseInt(st.nextToken());
		sC = Integer.parseInt(st.nextToken());
		fR = Integer.parseInt(st.nextToken());
		fC = Integer.parseInt(st.nextToken());

		bfs();
		System.out.print(result);
	}

	static void bfs() {
		q.add(new Location(sR, sC, 0));

		while (!q.isEmpty()) {
			Location now = q.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowCount = now.count;

			if (nowX == fR && nowY == fC) {
				result = nowCount;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int tempX = nowX + offsetX[i];
				int tempY = nowY + offsetY[i];
				if (tempX >= 1 && tempY >= 1 && tempX <= N && tempY <= M) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 0) {
						visited[tempX][tempY] = true;
						if (check(tempX, tempY)) {
							q.add(new Location(tempX, tempY, nowCount + 1));
						}
					}
				}
			}
		}
	}

	static boolean check(int x, int y) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (x + i > N || y + j > M || map[x + i][y + j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
