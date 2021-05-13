import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5624 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		boolean[] visited = new boolean[400001];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (visited[arr[i] - arr[j] + 200000]) {
					answer++;
					break;
				}
			}
			for (int j = 0; j <= i; j++) {
				visited[arr[i] + arr[j] + 200000] = true;
			}
		}
		System.out.print(answer);
	}
}
