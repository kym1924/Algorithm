import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_16113 {

	static char[][] arr;
	static int length;
	static char[][][] numbers = {
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },

			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' } }, };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		length = N / 5;
		String signal = br.readLine();

		arr = new char[5][length + 1];
		for (int i = 0; i < 5; i++) {
			int startIndex = length * i;
			arr[i] = signal.substring(startIndex, startIndex + length).toCharArray();
		}

		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == '.') {
				continue;
			}
			String num = String.valueOf(isElse(i));
			if (num.equals("6")) {
				if (i == arr[0].length - 1 || arr[0][i + 1] == '.') {
					bw.write("1");
				} else {
					bw.write(num);
					i += 2;
				}
			} else if (num.equals("1")) {
				bw.write(num);
			} else {
				bw.write(num);
				i += 2;
			}
		}
		bw.flush();
		bw.close();
	}

	static int isElse(int index) {
		for (int i = 0; i < 9; i++) {
			boolean check = true;
			L: for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3 && k + index < length; k++) {
					if (numbers[i][j][k] != arr[j][k + index]) {
						check = false;
						break L;
					}
				}
			}
			if (check) {
				if (i == 8) {
					return 0;
				}
				return i + 2;
			}
		}
		return 1;
	}
}
