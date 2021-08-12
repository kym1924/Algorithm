import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		StringBuilder sb = new StringBuilder(T);
		while (sb.length() > S.length()) {
			char last = sb.charAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			if (last == 'B') {
				sb.reverse();
			}
			if (sb.length() == S.length()) {
				if (sb.toString().equals(S)) {
					System.out.print(1);
				} else {
					System.out.print(0);
				}
			}
		}
	}
}
