import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] rope = new int[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope);

		int max = Integer.MIN_VALUE;
		int index = N;
		for (int i = 0; i < N; i++) {
			int temp = rope[i] * index--;
			max = Math.max(max, temp);
		}
		System.out.print(max);
	}
}
