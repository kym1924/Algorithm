import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_3649 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp;
		while ((temp = br.readLine()) != null) {
			int x = Integer.parseInt(temp) * 10000000;
			int N = Integer.parseInt(br.readLine());

			int[] lego = new int[N];
			for (int i = 0; i < N; i++) {
				lego[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(lego);
			int left = 0, right = lego.length - 1;
			boolean flag = false;

			while (left < right) {
				int sum = lego[left] + lego[right];
				if (sum == x) {
					bw.write("yes " + lego[left] + " " + lego[right] + "\n");
					flag = true;
					break;
				} else if (sum > x) {
					right--;
				} else {
					left++;
				}
			}
			if (!flag) {
				bw.write("danger\n");
			}
		}
		bw.flush();
		bw.close();
	}
}