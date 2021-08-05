import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9935 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String explore = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));

			if (sb.length() >= explore.length()) {
				int size = sb.length() - 1;
				boolean flag = true;
				for (int j = explore.length() - 1; j >= 0; j--) {
					if (sb.charAt(size--) != explore.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					sb.delete(sb.length() - explore.length(), sb.length());
				}
			}
		}

		if (sb.length() == 0) {
			System.out.print("FRULA");
		} else {
			System.out.print(sb.toString());
		}
	}
}