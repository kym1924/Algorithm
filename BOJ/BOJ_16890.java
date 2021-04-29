import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_16890 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String koosage = br.readLine();
		String cubeLover = br.readLine();
		int length = cubeLover.length();

		ArrayList<Character> gList = new ArrayList<>();
		ArrayList<Character> cList = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			gList.add(koosage.charAt(i));
			cList.add(cubeLover.charAt(i));
		}

		Collections.sort(gList);
		Collections.sort(cList, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();
		int gStart = 0, gEnd = (length + 1) / 2 - 1, cStart = 0, cEnd = (length / 2) - 1;

		for (int i = 0; i < length; i++) {
			if (i % 2 == 0) {
				if (gList.get(gStart) < cList.get(cStart)) {
					bw.write(gList.get(gStart));
					gStart++;
				} else {
					sb.append(gList.get(gEnd));
					gEnd--;
				}
			} else {
				if (gList.get(gStart) < cList.get(cStart)) {
					bw.write(cList.get(cStart));
					cStart++;
				} else {
					sb.append(cList.get(cEnd));
					cEnd--;
				}
			}
		}
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
	}
}
