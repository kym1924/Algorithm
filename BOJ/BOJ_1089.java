import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1089 {

	static int N;
	static double answer = 0;
	static char[][] lamp;
	static char[][][] numbers = {
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },

			{ { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },

			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } }, };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lamp = new char[5][4 * N - 1];
		for (int i = 0; i < 5; i++) {
			lamp[i] = br.readLine().toCharArray();
		}

		int pow = 1;
		for (int i = 0; i < 4 * N - 1; i += 4) {
			double temp = check(i, pow++);
			if (temp == -1) {
				System.out.print(-1);
				return;
			} else {
				answer += temp;
			}
		}
		System.out.print(answer);
	}

	static double check(int index, int pow) {
		int sum = 0, count = 0;
		for (int i = 0; i < 10; i++) {
			boolean possible = true;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {
					if (numbers[i][j][k] == '.' && lamp[j][k + index] == '#') {
						possible = false;
						break;
					}
				}
				if (!possible) {
					break;
				}
			}
			if (possible) {
				count++;
				sum += i;
			}
		}
		if (sum == 0) {
			return -1;
		}
		return sum * Math.pow(10, N - pow) / count;
	}
}
