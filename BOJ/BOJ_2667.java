import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2667 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] offsetX = { 1, 0, -1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };
	static int count = 0;
	static int size = 0;
	static ArrayList<Integer> result = new ArrayList<>();
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
		N = Integer.parseInt(br.readLine());
		String[] temp;
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					count++;
					size = 1;
					visited[i][j] = true;
					q.add(new Location(i, j));
					// dfs(i, j);
					bfs();
					result.add(size);
				}
			}
		}

		System.out.println(count);

		Collections.sort(result);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	static void dfs(int x, int y) {
		
		int tempX = x;
		int tempY = y;
		visited[tempX][tempY] = true;
		
		for (int i = 0; i < 4; i++) {
			tempX = x + offsetX[i];
			tempY = y + offsetY[i];
			if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
				if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
					size++;
					dfs(tempX, tempY);
				}
			}
		}
	}

	static void bfs() {
		
		while (!q.isEmpty()) {
			
			Location now = q.poll();
			int x = now.x;
			int y = now.y;
		
			for (int i = 0; i < 4; i++) {
				int tempX = x + offsetX[i];
				int tempY = y + offsetY[i];
				if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
					if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
						size++;
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}
	}
}
