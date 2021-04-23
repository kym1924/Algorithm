import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_5430 {

	static ArrayList<Character> p = new ArrayList<>();
	static ArrayList<Integer> intList = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			init();

			String[] temp = br.readLine().split("");
			for (int j = 0; j < temp.length; j++) {
				p.add(temp[j].charAt(0));
			}

			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
			for (int j = 0; j < n; j++) {
				intList.add(Integer.parseInt(arr[j]));
			}
			ac();
		}
		bw.flush();
		bw.close();
	}

	static void init() {
		p.clear();
		intList.clear();
	}

	static void ac() throws Exception {
		boolean reverse = false;
		boolean success = true;
		for (int i = 0; i < p.size(); i++) {
			char now = p.get(i);
			if (now == 'R') {
				reverse = !reverse;
			} else if (now == 'D') {
				if (intList.size() != 0) {
					if (!reverse) {
						intList.remove(0);
					} else {
						intList.remove(intList.size() - 1);
					}
				} else {
					success = false;
					break;
				}
			}
		}
		write(success, reverse);
	}

	static void write(boolean success, boolean reverse) throws Exception {
		if (success) {
			bw.write("[");
			if (reverse) {
				Collections.reverse(intList);
			}
			for (int i = 0; i < intList.size(); i++) {
				bw.write(String.valueOf(intList.get(i)));
				if (i != intList.size() - 1) {
					bw.write(",");
				}
			}
			bw.write("]");
		} else {
			bw.write("error");
		}
		bw.write("\n");
	}
}
