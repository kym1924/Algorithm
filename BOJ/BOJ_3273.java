import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int count = 0, check = 0;
		int left = 0, right = arr.length - 1;

		while (left < right) {
			int check = arr[left] + arr[right];
			if (check == answer) {
				count++;
				left++;
				right--;
			} else if (check > answer) {
				right--;
			} else {
				left++;
			}
		}

		System.out.print(count);
	}
}