import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {

	static int n, m, maxBroken = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] checked;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] offsetX = { 0, -1, 0, 1 };
	static int[] offsetY = { -1, 0, 1, 0 };

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		checked = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int roomCount = 0, maxRoom = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					int size = bfs(i, j, roomCount++);
					list.add(size);
					maxRoom = Math.max(maxRoom, size);
				}
			}
		}

		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					brokenWall(i, j);
				}
			}
		}

		bw.write(roomCount + "\n");
		bw.write(maxRoom + "\n");
		bw.write(maxBroken + "\n");
		bw.flush();
		bw.close();
	}

	static int bfs(int x, int y, int roomCount) {
		int room = 0;
		Queue<Location> q = new LinkedList<>();
		visited[x][y] = true;
		checked[x][y] = roomCount;
		q.add(new Location(x, y));

		while (!q.isEmpty()) {
			Location now = q.poll();
			room++;
			int tempX = now.x;
			int tempY = now.y;
			int wall = 1;
			for (int i = 0; i < 4; i++) {
				if ((map[now.x][now.y] & wall) != wall) {
					tempX = now.x + offsetX[i];
					tempY = now.y + offsetY[i];
					if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n) {
						if (!visited[tempX][tempY]) {
							visited[tempX][tempY] = true;
							checked[tempX][tempY] = roomCount;
							q.add(new Location(tempX, tempY));
						}
					}
				}
				wall *= 2;
			}
		}

		return room;
	}

	static void brokenWall(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Location(x, y));
		int room1 = checked[x][y];

		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX = now.x;
			int tempY = now.y;
			for (int i = 0; i < 4; i++) {
				tempX = now.x + offsetX[i];
				tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n) {
					if (!visited[tempX][tempY]) {
						int room2 = checked[tempX][tempY];
						if (room1 != room2) {
							maxBroken = Math.max(maxBroken, list.get(room1) + list.get(room2));
						}
					}
				}
			}
		}
	}
}
