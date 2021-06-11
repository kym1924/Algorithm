import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16927 {

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
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			int mod = (2 * (N - 2 * i)) + (2 * (M - 2 * i)) - 4;
			list.add(mod);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < R % list.get(i); j++) {
				int temp = arr[i][i];
				for (int k = i + 1; k < M - i; k++) {
					arr[i][k - 1] = arr[i][k];
				}
				for (int k = i + 1; k < N - i; k++) {
					arr[k - 1][M - 1 - i] = arr[k][M - 1 - i];
				}
				for (int k = M - i - 1; k > i; k--) {
					arr[N - i - 1][k] = arr[N - i - 1][k - 1];
				}
				for (int k = N - i - 1; k > i; k--) {
					arr[k][i] = arr[k - 1][i];
				}
				arr[i + 1][i] = temp;
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