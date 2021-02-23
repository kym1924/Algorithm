import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2231 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			String strCheck = String.valueOf(i);
			int intCheck = i;
			for (int j = 0; j < strCheck.length(); j++) {
				intCheck += Character.getNumericValue(strCheck.charAt(j));
			}
			if (intCheck == N) {
				System.out.print(i);
				return;
			}
		}
		System.out.print(0);
	}
}
