import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] height = new int[N + 1];
		double[][] gradient = new double[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				gradient[i][j] = (double) (height[j] - height[i]) / (j - i);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				System.out.printf(String.format("%.2f ", gradient[i][j]));
			System.out.println();
		}

		double max;
		int count = 0;
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			count = 0;
			max = Integer.MIN_VALUE;
			for (int j = i + 1; j <= N; j++) {
				if (gradient[i][j] > max) {
					count++;
					max = gradient[i][j];
				}
			}
			max = Integer.MAX_VALUE;
			for (int j = i - 1; j > 0; j--) {
				if (gradient[i][j] < max) {
					count++;
					max = gradient[i][j];
				}
			}
			if (answer < count) {
				answer = count;
			}
		}

		System.out.print(answer);

//		System.out.print(Arrays.toString(result));
//		int answer = 0;
//		for (int i = 1; i <= N; i++) {
//			if (answer < result[i]) {
//				answer = result[i];
//			}
//		}
//		System.out.print(answer);
	}
}
