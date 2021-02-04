import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {

	static int n, m;
	static int[][] map;
	static int[][] answer;
	static boolean[][] visited;
	static int goalx, goaly;
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

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					goalx = i;
					goaly = j;
				}
			}
		}

		bfs(goalx, goaly);
		print();
	}

	static void bfs(int i, int j) {
		q.add(new Location(i, j));

		while (!q.isEmpty()) {
			Location now = q.poll();
			int x = now.x;
			int y = now.y;
			for (int k = 0; k < 4; k++) {
				int tempx = x + offsetX[k];
				int tempy = y + offsetY[k];
				if (tempx >= 0 && tempy >= 0 && tempx < n && tempy < m) {
					if (!visited[tempx][tempy] && map[tempx][tempy] == 1) {
						visited[tempx][tempy] = true;
						answer[tempx][tempy] = answer[x][y] + 1;
						q.add(new Location(tempx, tempy));
					}
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (answer[i][j] == 0 && map[i][j] != 0 && map[i][j] != 2) {
					System.out.print(-1 + " ");
				} else {
					System.out.print(answer[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
