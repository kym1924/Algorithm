import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1303 {

	static int white = 0;
	static int blue = 0;
	static int N, M;
	static String[][] soldier;
	static boolean[][] visited;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, -1, 0, 1 };
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);

		soldier = new String[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				soldier[i][j] = temp[j];
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					if (soldier[i][j].equals("W")) {
						bfs(i, j, "W");
					} else {
						bfs(i, j, "B");
					}
				}
			}
		}

		bw.write(white + " " + blue);
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y, String team) {
		visited[x][y] = true;
		q.add(new Location(x, y));

		int count = 1;
		while (!q.isEmpty()) {
			Location now = q.poll();
			int tempX = now.x;
			int tempY = now.y;
			for (int k = 0; k < 4; k++) {
				tempX = now.x + offsetX[k];
				tempY = now.y + offsetY[k];
				if (tempX >= 0 && tempX < M && tempY >= 0 && tempY < N) {
					if (!visited[tempX][tempY] && soldier[tempX][tempY].equals(team)) {
						count++;
						visited[tempX][tempY] = true;
						q.add(new Location(tempX, tempY));
					}
				}
			}
		}

		if (team.equals("W")) {
			white += count * count;
		} else {
			blue += count * count;
		}
	}
}
