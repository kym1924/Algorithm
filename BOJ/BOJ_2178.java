import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2178 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] answer;
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
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		answer = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			temp = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(temp[j - 1]);
			}
		}

		bfs(1, 1);
		System.out.print(answer[N][M]);
	}

	static void bfs(int x, int y) {
		answer[x][y] = 1;
		visited[x][y] = true;
		q.add(new Location(x, y));

		while (!q.isEmpty()) {
			Location now = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempX = now.x + offsetX[i];
				int tempY = now.y + offsetY[i];
				if (tempX >= 1 && tempX <= N && tempY >= 1 && tempY <= M) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
						answer[tempX][tempY] = answer[now.x][now.y] + 1;
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}

}
