import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static int n, m;
	static int[][] count;
	static boolean[][] visited;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, -1, 0, 1 };

	static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;
		count = new int[n][m];
		visited = new boolean[n][m];

		bfs(maps, 0, 0);
		return (count[n - 1][m - 1] == 0) ? -1 : count[n - 1][m - 1];
	}

	static void bfs(int[][] map, int startX, int startY) {
		Queue<Location> q = new LinkedList<>();
		count[startX][startY] = 1;
		visited[startX][startY] = true;
		q.add(new Location(startX, startY));

		while (!q.isEmpty()) {
			Location now = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempX = now.x + offsetX[i];
				int tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < m) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
						count[tempX][tempY] = count[now.x][now.y] + 1;
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}
}