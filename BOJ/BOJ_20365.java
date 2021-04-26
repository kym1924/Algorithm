import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_20365 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[] problem = br.readLine().toCharArray();

		int blue = problem[0] == 'B' ? 1 : 0;
		int red = problem[0] == 'R' ? 1 : 0;

		for (int i = 1; i < N; i++) {
			if (problem[i] == 'B' && problem[i - 1] == 'R') {
				blue++;
			} else if (problem[i] == 'R' && problem[i - 1] == 'B') {
				red++;
			}
		}

		if (blue < red) {
			bw.write(String.valueOf(blue + 1));
		} else {
			bw.write(String.valueOf(red + 1));
		}

		bw.flush();
		bw.close();
	}
}
