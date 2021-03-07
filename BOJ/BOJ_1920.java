import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int check = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (A[mid] == check) {
					bw.write("1\n");
					break;
				} else if (A[mid] > check) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			if (left > right) {
				bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
