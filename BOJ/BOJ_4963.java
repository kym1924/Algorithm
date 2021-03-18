import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Location> q = new LinkedList<>();
	static int[] offsetX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] offsetY = { -1, 0, 1, -1, 1, -1, 0, 1 };

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
		StringTokenizer st = new StringTokenizer("");

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						count++;
						bfs(i, j);
					}
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void bfs(int i, int j) {
		visited[i][j] = true;
		q.add(new Location(i, j));
		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX = 0, tempY = 0;
			for (int k = 0; k < 8; k++) {
				tempX = now.x + offsetX[k];
				tempY = now.y + offsetY[k];
				if (tempX >= 0 && tempX < h && tempY >= 0 && tempY < w) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}
}
