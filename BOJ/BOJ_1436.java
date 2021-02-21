import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 666;
		int index = 0;

		while (index != N) {
			if (String.valueOf(answer).contains("666")) {
				index++;
				if (index == N) {
					break;
				}
			}
			answer++;
		}

		System.out.print(answer);
	}
}
