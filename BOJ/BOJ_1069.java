import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1069 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		double distance = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		int jump = (int) (distance / D);

		double answer = Integer.MAX_VALUE;
		if (distance >= D) {
			answer = Math.min(distance, jump * T + distance - (jump * D));
			answer = Math.min(answer, (jump + 1) * T);
		} else {
			answer = Math.min(distance, T + D - distance);
			answer = Math.min(answer, 2 * T);
		}
		System.out.print(answer);
	}
}