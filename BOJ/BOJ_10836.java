import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10836 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] bee = new int[M][M];
		int[] diff = new int[2 * M - 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = 0;
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			for (int j = index; j < zero; j++) {
				index++;
			}
			for (int j = 0; j < one; j++) {
				diff[index++] += 1;
			}
			for (int j = 0; j < two; j++) {
				diff[index++] += 2;
			}
		}

		int index = 0;
		for (int i = M - 1; i >= 0; i--) {
			bee[i][0] += diff[index++];
		}
		for (int i = 1; i < M; i++) {
			bee[0][i] += diff[index++];
		}
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				bee[i][j] = bee[0][j];
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				bw.write((bee[i][j] + 1) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
