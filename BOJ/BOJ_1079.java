import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1079 {

	static int N, mafia;
	static int answer = Integer.MIN_VALUE;
	static int[] guilty;
	static int[][] R;
	static boolean[] die;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		die = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		guilty = new int[N];
		for (int i = 0; i < N; i++) {
			guilty[i] = Integer.parseInt(st.nextToken());
		}

		R = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		mafia = Integer.parseInt(br.readLine());
		dfs(N, 0);
		System.out.print(answer);
	}

	static void dfs(int remain, int night) {
		if (die[mafia] || remain == 1) {
			if (answer < night) {
				answer = night;
			}
			return;
		}

		if (remain % 2 == 0) {
			for (int i = 0; i < N; i++) {
				if (i == mafia || die[i]) {
					continue;
				}
				die[i] = true;
				for (int j = 0; j < N; j++) {
					guilty[j] += R[i][j];
				}
				dfs(remain - 1, night + 1);
				die[i] = false;
				for (int j = 0; j < N; j++) {
					guilty[j] -= R[i][j];
				}
			}
		} else {
			int maxIndex = -1;
			int maxGuilty = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if (maxGuilty < guilty[i] && !die[i]) {
					maxGuilty = guilty[i];
					maxIndex = i;
				}
			}
			die[maxIndex] = true;
			dfs(remain - 1, night);
			die[maxIndex] = false;
		}
	}
}
