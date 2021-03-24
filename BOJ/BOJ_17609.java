import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_17609 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String temp = br.readLine();
			bw.write(String.valueOf(isPalindrome(temp) + "\n"));
		}
		bw.flush();
		bw.close();
	}

	static int isPalindrome(String temp) {
		int left = 0, right = temp.length() - 1;
		while (left < right) {
			if (temp.charAt(left) == temp.charAt(right)) {
				left++;
				right--;
			} else {
				if (isSimilarity(temp, left + 1, right) || isSimilarity(temp, left, right - 1)) {
					return 1;
				} else {
					return 2;
				}
			}
		}
		return 0;
	}

	static boolean isSimilarity(String temp, int left, int right) {
		while (left < right) {
			if (temp.charAt(left) == temp.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}
}