import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2589 {

	static int result = Integer.MIN_VALUE;
	static int L, W;
	static char[][] map;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, -1, 0, 1 };

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
		L = Integer.parseInt(temp[0]);
		W = Integer.parseInt(temp[1]);
		map = new char[L][W];
		for (int i = 0; i < L; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.print(result);
	}

	static void bfs(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		boolean[][] visited = new boolean[L][W];
		q.add(new Location(x, y, 0));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX = now.x, tempY = now.y;
			result = Math.max(result, now.count);
			for (int i = 0; i < 4; i++) {
				tempX = now.x + offsetX[i];
				tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < L && tempY >= 0 && tempY < W) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 'L') {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY, now.count + 1));
					}
				}
			}
		}
	}
}
