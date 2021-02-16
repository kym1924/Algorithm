import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_2470 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = N - 1, check;
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];

		Arrays.sort(arr);

		while (left < right) {
			check = arr[left] + arr[right];
			if (min > Math.abs(check)) {
				min = Math.abs(check);
				answer[0] = arr[left];
				answer[1] = arr[right];
			}
			if (check <= 0) {
				left++;
			} else {
				right--;
			}
		}

		Arrays.sort(answer);

		System.out.println(answer[0] + " " + answer[1]);
	}
}
