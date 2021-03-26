import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1) {
			System.out.print("A");
			return;
		} else if (N == 2) {
			if (arr[0] == arr[1]) {
				System.out.print(arr[0]);
			} else {
				System.out.print("A");
			}
			return;
		} else {
			int a = arr[1] - arr[0] != 0 ? (arr[2] - arr[1]) / (arr[1] - arr[0]) : 0;
			int b = arr[1] - (arr[0] * a);
			for (int i = 1; i < N; i++) {
				if (arr[i] != arr[i - 1] * a + b) {
					System.out.print("B");
					return;
				}
			}
			System.out.print(arr[N - 1] * a + b);
		}
	}
}