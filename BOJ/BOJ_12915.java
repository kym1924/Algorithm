import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12915 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] question = new int[5];
		for (int i = 0; i < 5; i++) {
			question[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		while (true) {
			if (question[0] <= 0) {
				if (question[1] > 0) {
					question[1]--;
					question[0]++;
				}
			}
			if (question[4] <= 0) {
				if (question[3] > 0) {
					question[3]--;
					question[4]++;
				}
			}
			if (question[2] <= 0) {
				if (question[1] >= question[3]) {
					if (question[1] > 0) {
						question[1]--;
						question[2]++;
					}
				} else {
					if (question[3] > 0) {
						question[3]--;
						question[2]++;
					}
				}
			}
			if (question[0] > 0 && question[2] > 0 && question[4] > 0) {
				count++;
				question[0]--;
				question[2]--;
				question[4]--;
			} else {
				break;
			}
		}
		System.out.print(count);
	}
}
