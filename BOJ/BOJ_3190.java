import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BOJ_3190 {

	static int N;
	static int[][] map;
	static int[] offsetX = { 0, 1, 0, -1 };
	static int[] offsetY = { 1, 0, -1, 0 };
	static ArrayList<Rotation> list = new ArrayList<>();
	static Deque<Location> dq = new ArrayDeque<>();

	static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Rotation {
		int time;
		char direction;

		Rotation(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int appleR = Integer.parseInt(st.nextToken());
			int appleC = Integer.parseInt(st.nextToken());
			map[appleR][appleC] = 1;
		}

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			list.add(new Rotation(time, direction));
		}

		System.out.print(start(1, 1));
	}

	static int start(int x, int y) {
		map[x][y] = 2;
		dq.add(new Location(x, y));

		int time = 0, direction = 0, rotation = 0;
		while (true) {
			time++;
			int tempX = x + offsetX[direction % 4];
			int tempY = y + offsetY[direction % 4];
			if (outOfMap(tempX, tempY) || touchBody(tempX, tempY)) {
				return time;
			}
			if (map[tempX][tempY] == 0) {
				move(tempX, tempY);
			} else if (map[tempX][tempY] == 1) {
				eatApple(tempX, tempY);
			}
			if (rotation < list.size()) {
				Rotation r = list.get(rotation);
				if (r.time == time) {
					if (r.direction == 'D') {
						direction = direction + 1 == 4 ? 0 : direction + 1;
					} else if (r.direction == 'L') {
						direction = direction - 1 == -1 ? 3 : direction - 1;
					}
					rotation++;
				}
			}
			x = tempX;
			y = tempY;
		}
	}

	static boolean outOfMap(int x, int y) {
		if (x <= 0 || x > N || y <= 0 || y > N) {
			return true;
		}
		return false;
	}

	static boolean touchBody(int x, int y) {
		if (map[x][y] == 2) {
			return true;
		}
		return false;
	}

	static void move(int x, int y) {
		Location tail = dq.pollFirst();
		map[tail.x][tail.y] = 0;
		dq.add(new Location(x, y));
		map[x][y] = 2;
	}

	static void eatApple(int x, int y) {
		dq.add(new Location(x, y));
		map[x][y] = 2;
	}
}
