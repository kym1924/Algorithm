import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9177 {

	static String[] words;
	static boolean flag;

	static class Index {
		int first;
		int second;
		int third;

		Index(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			words = br.readLine().split(" ");
			flag = false;

			bfs();

			if (flag) {
				bw.write("Data set " + i + ": yes\n");
			} else {
				bw.write("Data set " + i + ": no\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static void bfs() {
		boolean[][] visited = new boolean[words[0].length() + 1][words[1].length() + 1];
		Queue<Index> q = new LinkedList<>();
		q.add(new Index(0, 0, 0));

		while (!q.isEmpty()) {
			Index now = q.poll();
			int first = now.first;
			int second = now.second;
			int third = now.third;

			if (third == words[2].length()) {
				flag = true;
				return;
			}

			if (first < words[0].length() && !visited[first + 1][second]) {
				if (words[0].charAt(first) == words[2].charAt(third)) {
					visited[first + 1][second] = true;
					q.add(new Index(first + 1, second, third + 1));
				}
			}

			if (second < words[1].length() && !visited[first][second + 1]) {
				if (words[1].charAt(second) == words[2].charAt(third)) {
					visited[first][second + 1] = true;
					q.add(new Index(first, second + 1, third + 1));
				}
			}
		}
	}
}