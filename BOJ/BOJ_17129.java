import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17129 {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Location> q = new LinkedList<>();
	static int[] offsetX = { 0, 0, 1, -1 };
	static int[] offsetY = { 1, -1, 0, 0 };

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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		map = new int[n][m];
		visited = new boolean[n][m];

		int startX = 0, startY = 0;
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(startX, startY);
	}

	static void bfs(int x, int y) {
		visited[x][y] = true;
		q.add(new Location(x, y, 0));

		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX = now.x;
			int tempY = now.y;
			int count = now.count;

			if (3 <= map[tempX][tempY] && map[tempX][tempY] <= 5) {
				System.out.println("TAK\n" + count);
				return;
			}

			for (int i = 0; i < 4; i++) {
				tempX = now.x + offsetX[i];
				tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < m) {
					if (!visited[tempX][tempY] && map[tempX][tempY] != 1) {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY, count + 1));
					}
				}
			}
		}
		System.out.print("NIE");
	}
}
