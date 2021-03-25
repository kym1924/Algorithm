import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15922 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int x, y, total = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if (x > max) {
				total += Math.abs(y - x);
				min = x;
				max = y;
			} else if (x <= max && y > max) {
				total += Math.abs(y - max);
				max = y;
			} else if (x >= min && y <= max) {
				continue;
			}
		}
		System.out.print(total);
	}
}