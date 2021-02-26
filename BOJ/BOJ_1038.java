import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1038 {
	static ArrayList<Long> arr = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N > 1022) {
			System.out.print(-1);
			return;
		}

		for (long i = 0; i < 10; i++) {
			arr.add(i);
		}

		for (int i = 1; i < 1022; i++) {
			long check = arr.get(i);
			if (check % 10 != 0) {
				long last = check % 10;
				for (int j = 0; j < last; j++) {
					arr.add(check * 10 + j);
				}
			}
		}

		System.out.print(arr.get(N));
	}
}
