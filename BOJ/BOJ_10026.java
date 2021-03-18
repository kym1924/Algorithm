import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

	static int N;
	static char[][] area;
	static boolean[][] visited;
	static Queue<Location> q = new LinkedList<>();
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };

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
		N = Integer.parseInt(br.readLine());
		area = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			area[i] = br.readLine().toCharArray();
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					count++;
					bfs(i, j);
				}
			}
		}
		bw.write(String.valueOf(count) + " ");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
				if (area[i][j] == 'G') {
					area[i][j] = 'R';
				}
			}
		}

		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					count++;
					bfs(i, j);
				}
			}
		}
		bw.write(String.valueOf(count));

		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y) {
		char check = area[x][y];
		q.add(new Location(x, y));

		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX, tempY;
			for (int i = 0; i < 4; i++) {
				tempX = now.x + offsetX[i];
				tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
					if (!visited[tempX][tempY] && area[tempX][tempY] == check) {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}
}