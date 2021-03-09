import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);

		int result = 0;
		for (int i = 0; i < N; i++) {
			int minute = time[i];
			for (int j = i - 1; j >= 0; j--) {
				minute += time[j];
			}
			result += minute;
		}
		System.out.print(result);
	}
}
