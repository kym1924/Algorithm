import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_4889 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int index = 0;

		while (true) {
			index++;
			char[] now = br.readLine().toCharArray();
			if (now[0] == '-') {
				break;
			}

			ArrayList<Character> list = new ArrayList<>();
			for (int i = 0; i < now.length; i++) {
				if (now[i] == '{') {
					list.add(now[i]);
				} else if (now[i] == '}') {
					if (list.isEmpty() || list.get(list.size() - 1) == '}') {
						list.add(now[i]);
					} else if (list.get(list.size() - 1) == '{') {
						list.remove(list.size() - 1);
					}
				}
			}

			int answer = 0;
			for (int i = list.size() - 1; i > 0; i -= 2) {
				if (list.get(i) == list.get(i - 1)) {
					answer++;
				} else {
					answer += 2;
				}
			}
			bw.write(index + ". " + answer + "\n");
		}
		bw.flush();
		bw.close();
	}
}