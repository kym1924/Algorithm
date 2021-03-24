import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1034 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int[][] lamp = new int[N][M];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				lamp[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int K = Integer.parseInt(br.readLine());

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int zero = 0;
			for (int j = 0; j < M; j++) {
				if (lamp[i][j] == 0) {
					zero++;
				}
			}
			int sameLine = 0;
			if (zero <= K && zero % 2 == K % 2) {
				for (int k = 0; k < N; k++) {
					int sameCount = 0;
					for (int l = 0; l < M; l++) {
						if (lamp[i][l] == lamp[k][l]) {
							sameCount++;
						}
					}
					if (sameCount == M) {
						sameLine++;
					}
				}
			}
			answer = Math.max(answer, sameLine);
		}
		System.out.print(answer);
	}
}
