import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {

	static int N, M;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<Point> house = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	static boolean[] visited;

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1) {
					house.add(new Point(i, j));
				} else if (now == 2) {
					chicken.add(new Point(i, j));
				} else {
					continue;
				}
			}
		}
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.print(answer);
	}

	static void dfs(int selected, int count) {
		if (count == M) {
			answer = Math.min(answer, cal());
		} else {
			for (int i = selected; i < chicken.size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(i, count + 1);
					visited[i] = false;
				}
			}
		}
	}

	static int cal() {
		int sum = 0;
		for (Point point : house) {
			int distance = Integer.MAX_VALUE;
			for (int i = 0; i < chicken.size(); i++) {
				if (visited[i]) {
					distance = Math.min(distance, distance(point, chicken.get(i)));
				}
			}
			sum += distance;
		}
		return sum;
	}

	static int distance(Point house, Point chicken) {
		return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
	}
}