import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int answer = Math.abs(N - 100);

        boolean brokenCheck;
		for (int i = 0; i <= 1000000; i++) {
			brokenCheck = false;
			if (i == 0) {
				if (broken[0]) {
					brokenCheck = true;
				}
			}
			for (int j = i; j > 0; j /= 10) {
				if (broken[j % 10]) {
					brokenCheck = true;
					break;
				}
			}
			if (!brokenCheck) {
				answer = Math.min(answer, (Math.abs(N - i) + length(i)));
			}
		}
		System.out.println(answer);
	}

	static int length(int N) {
		return (N == 0) ? 1 : (int) Math.log10(N) + 1;
	}
}