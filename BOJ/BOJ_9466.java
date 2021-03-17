import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_9466 {

	static int answer;
	static int[] student;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			answer = n;
			student = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				student[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					dfs(j);
				}
			}
			bw.write(String.valueOf(answer) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void dfs(int num) {
		visited[num] = true;

		if (!visited[student[num]]) {
			dfs(student[num]);
		} else if (!finished[student[num]]) {
			answer--;
			for (int i = student[num]; i != num; i = student[i]) {
				answer--;
			}
		}
		finished[num] = true;
	}
}
