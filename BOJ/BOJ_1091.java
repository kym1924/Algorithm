import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1091 {

	static int N;
	static int[] P, temp, copy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		P = new int[N];
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] S = new int[N];
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		temp = P.clone();
		int count = 0;
		while (true) {
			boolean check = true;
			for (int i = 0; i < N; i++) {
				if (temp[i] != i % 3) {
					check = false;
					break;
				}
			}
			if (check) {
				break;
			} else {
				copy = temp.clone();
				count++;
				for (int i = 0; i < N; i++) {
					temp[S[i]] = copy[i];
				}
				if (cycleCheck()) {
					System.out.print(-1);
					return;
				}
			}
		}
		System.out.print(count);
	}

	static boolean cycleCheck() {
		for (int i = 0; i < N; i++) {
			if (temp[i] != P[i]) {
				return false;
			}
		}
		return true;
	}
}
