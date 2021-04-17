import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1759 {

	static int L, C;
	static char[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		dfs(-1, "");
		bw.flush();
		bw.close();
	}

	static void dfs(int index, String password) throws Exception {
		if (password.length() == L) {
			int vowelCount = 0, consonantCount = 0;
			for (int i = 0; i < password.length(); i++) {
				char now = password.charAt(i);
				if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
					vowelCount++;
				} else {
					consonantCount++;
				}
			}
			if (vowelCount >= 1 && consonantCount >= 2) {
				bw.write(password + "\n");
			}
		}
		for (int i = index + 1; i < C; i++) {
			dfs(i, password + arr[i]);
		}
	}
}