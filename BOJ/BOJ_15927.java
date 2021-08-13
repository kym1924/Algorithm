import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String reverse = new StringBuilder(str).reverse().toString();

		if (!(str.equals(reverse))) {
			System.out.print(str.length());
		} else {
			boolean check = false;
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) != str.charAt(i + 1)) {
					check = true;
					break;
				}
			}
			if (!check) {
				System.out.print(-1);
			} else {
				System.out.print(str.length() - 1);
			}
		}
	}
}
