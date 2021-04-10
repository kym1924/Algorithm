import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5636 {

	static boolean[] isNotPrime = new boolean[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		initPrime();

		String number;
		while (!(number = br.readLine()).equals("0")) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < number.length(); i++) {
				for (int j = i + 1; j <= number.length(); j++) {
					String subString = number.substring(i, j);
					if (subString.length() < 6) {
						int check = Integer.parseInt(subString);
						if (check <= 100000) {
							if (!isNotPrime[check]) {
								max = Math.max(max, check);
							}
						}
					} else {
						break;
					}
				}
			}
			bw.write(String.valueOf(max) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void initPrime() {
		for (int i = 2; i <= 100000; i++) {
			for (int j = i + i; j <= 100000; j += i) {
				if (!isNotPrime[j]) {
					isNotPrime[j] = true;
				}
			}
		}
	}
}