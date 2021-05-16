import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {

	static int N;
	static int answer = Integer.MAX_VALUE;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, -1, 0, 1 };
	static int[][] map;
	static boolean[][] visited;
	static int[][] island;
	static int[][] dist;

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
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		island = new int[N][N];
		dist = new int[N][N];
		visited = new boolean[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int number = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j, number++);
				}
			}
		}

		for (int i = 1; i < number; i++) {
			find(i);
		}
		System.out.print(answer);
	}

	static void bfs(int x, int y, int number) {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		visited[x][y] = true;
		island[x][y] = number;

		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX = now.x, tempY = now.y;
			for (int i = 0; i < 4; i++) {
				tempX = now.x + offsetX[i];
				tempY = now.y + offsetY[i];
				if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
					if (map[tempX][tempY] == 1 && !visited[tempX][tempY]) {
						q.add(new Location(tempX, tempY));
						visited[tempX][tempY] = true;
						island[tempX][tempY] = number;
					}
				}
			}
		}
	}

	static void find(int number) {
		Queue<Location> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (island[i][j] == number) {
					q.add(new Location(i, j));
					visited[i][j] = true;
				}
			}
		}

		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Location now = q.poll();
				int tempX = now.x, tempY = now.y;
				for (int j = 0; j < 4; j++) {
					tempX = now.x + offsetX[j];
					tempY = now.y + offsetY[j];
					if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
						if (island[tempX][tempY] != number && map[tempX][tempY] == 1) {
							answer = Math.min(answer, distance);
							return;
						}
						if (map[tempX][tempY] == 0 && !visited[tempX][tempY]) {
							visited[tempX][tempY] = true;
							q.add(new Location(tempX, tempY));
						}
					}
				}
			}
			distance++;
		}
	}
}
