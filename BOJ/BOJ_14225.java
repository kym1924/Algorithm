import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temp {

	static int N;
	static int[] arr;
	static boolean[] visited = new boolean[20 * 100000 + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);

		for (int i = 0; i <= 20 * 100000; i++) {
			if (!visited[i]) {
				System.out.print(i);
				break;
			}
		}
	}

	static void dfs(int index, int sum) {
		if (index == N) {
			visited[sum] = true;
			return;
		} else {
			dfs(index + 1, sum + arr[index]);
			dfs(index + 1, sum);
		}
	}
}
