import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class BOJ_16925 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[2 * N - 2];
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> s = new ArrayList<>();

		for (int i = 0; i < 2 * N - 2; i++) {
			String temp = br.readLine();
			if (temp.length() == 1) {
				p.add(temp);
			}
			if (temp.length() == N - 1) {
				s.add(temp);
			}
			input[i] = temp;
		}

		String original = "";
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		L: for (int i = 0; i < p.size(); i++) {
			for (int j = 0; j < s.size(); j++) {
				sb.setLength(0);
				sb.append(p.get(i));
				sb.append(s.get(j));
				if (check(sb.toString(), input)) {
					original = sb.toString();
					bw.write(original + "\n");
					for (int k = 0; k < input.length; k++) {
						String temp = input[k];
						if (original.startsWith(input[k])) {
							if (!set.contains(temp)) {
								bw.write("P");
							} else {
								bw.write("S");
							}
						} else if (original.endsWith(input[k])) {
							if (!set.contains(temp)) {
								bw.write("S");
							} else {
								bw.write("P");
							}
						}
						set.add(temp);
					}
					break L;
				}
			}
		}
		bw.flush();
		bw.close();
	}

	static boolean check(String original, String[] input) {
		for (int i = 0; i < input.length; i++) {
			if (original.startsWith(input[i]) || original.endsWith(input[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
