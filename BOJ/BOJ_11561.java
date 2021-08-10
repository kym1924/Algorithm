import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11561 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			long N = Long.parseLong(br.readLine());
			long left = 1, right = 200000000l;
			while (left <= right) {
				long mid = (left + right) / 2;
				long check = mid * (mid + 1) / 2;
				if (check > N) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			bw.append(right + "\n");
		}
		bw.flush();
		bw.close();
	}
}
