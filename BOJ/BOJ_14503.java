import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {

	static int N, M;
	static int answer = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleanUp(r, c, d);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.print(answer);
	}

	static void cleanUp(int r, int c, int d) {

		if (map[r][c] == 0) {
			answer++;
			map[r][c] = -1;
		}

		int tempR = r, tempC = c, tempD = d;
		for (int i = 0; i < 4; i++) {
			tempD = tempD == 0 ? 3 : tempD - 1;
			tempR = r + offsetX[tempD];
			tempC = c + offsetY[tempD];
			if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < M) {
				if (map[tempR][tempC] == 0) {
					cleanUp(tempR, tempC, tempD);
					return;
				}
			}
		}
		if (map[r - offsetX[d]][c - offsetY[d]] != 1) {
			cleanUp(r - offsetX[d], c - offsetY[d], d);
		} else {
			return;
		}
	}
}