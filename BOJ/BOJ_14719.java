import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] height = new int[W];
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i = 1; i < W - 1; i++) {
			int left = 0, right = 0;
			for (int j = i; j >= 0; j--) {
				if (height[j] == H) {
					left = H;
					break;
				}
				left = Math.max(left, height[j]);
			}
			for (int j = i; j < W; j++) {
				if (height[j] == H) {
					right = H;
					break;
				}
				right = Math.max(right, height[j]);
			}
			answer += Math.max(0, Math.min(left, right) - height[i]);
		}
		System.out.print(answer);
	}
}
