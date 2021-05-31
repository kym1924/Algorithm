import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12842 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
		int s = Integer.parseInt(temp[1]);

		int m = Integer.parseInt(br.readLine());
		int[] time = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		int second = 0;
		while (n != s) {
			for (int i = 1; i <= m; i++) {
				if (second % time[i] == 0) {
					n--;
				}
				if (n == s) {
					System.out.print(i);
					break;
				}
			}
			second++;
		}
	}
}
