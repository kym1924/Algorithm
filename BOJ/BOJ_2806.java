import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] dna = (br.readLine() + "A").toCharArray();

		int answer = 0;
		for (int i = 1; i < N; i++) {
			char now = dna[i];
			if (dna[i - 1] != dna[i] && dna[i] != dna[i + 1]) {
				if (now == 'A') {
					dna[i] = 'B';
				} else if (now == 'B') {
					dna[i] = 'A';
				}
				answer++;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (dna[i - 1] != dna[i]) {
				answer++;
			}
		}
		System.out.print(answer);
	}
}