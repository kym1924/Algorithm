import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16926 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = Math.min(N, M) / 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < r; j++) {
				int temp = arr[j][j];
				for (int k = j + 1; k < M - j; k++) {
					arr[j][k - 1] = arr[j][k];
				}
				for (int k = j + 1; k < N - j; k++) {
					arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];
				}
				for (int k = M - j - 1; k > j; k--) {
					arr[N - j - 1][k] = arr[N - j - 1][k - 1];
				}
				for (int k = N - j - 1; k > j; k--) {
					arr[k][j] = arr[k - 1][j];
				}
				arr[j + 1][j] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}