import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17143 {

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int R, C, M;
	static int answer = 0;
	static int[][] existed;
	static Map<Integer, Shark> map = new HashMap<>();
	static int[] offsetX = { 0, -1, 1, 0, 0 };
	static int[] offsetY = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		existed = new int[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			existed[r][c] = z;
			map.put(z, new Shark(r, c, s, d, z));
		}

		for (int i = 1; i <= C; i++) {
			for (int j = 1; j <= R; j++) {
				if (existed[j][i] != 0) {
					answer += existed[j][i];
					map.remove(existed[j][i]);
					existed[j][i] = 0;
					break;
				}
			}

			ArrayList<Integer> smaller = new ArrayList<>();
			int[][] temp = new int[R + 1][C + 1];

			for (Integer key : map.keySet()) {
				Shark shark = map.get(key);
				existed[shark.r][shark.c] = 0;

				if (shark.d <= 2) {
					shark.s %= (R * 2) - 2;
				} else {
					shark.s %= (C * 2) - 2;
				}

				for (int k = 0; k < shark.s; k++) {
					if (shark.d == 1 && shark.r == 1) {
						shark.d = 2;
					} else if (shark.d == 2 && shark.r == R) {
						shark.d = 1;
					} else if (shark.d == 3 && shark.c == C) {
						shark.d = 4;
					} else if (shark.d == 4 && shark.c == 1) {
						shark.d = 3;
					}
					shark.r += offsetX[shark.d];
					shark.c += offsetY[shark.d];
				}

				if (temp[shark.r][shark.c] == 0) {
					temp[shark.r][shark.c] = shark.z;
				} else {
					if (temp[shark.r][shark.c] < shark.z) {
						smaller.add(temp[shark.r][shark.c]);
						temp[shark.r][shark.c] = shark.z;
					} else {
						smaller.add(shark.z);
					}
				}
			}

			for (int j = 0; j < smaller.size(); j++) {
				map.remove(smaller.get(j));
			}

			for (Integer key : map.keySet()) {
				Shark shark = map.get(key);
				existed[shark.r][shark.c] = temp[shark.r][shark.c];
			}
		}
		System.out.print(answer);
	}
}