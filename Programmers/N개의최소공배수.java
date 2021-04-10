import java.util.Arrays;

class Solution {
	public int solution(int[] arr) {
		Arrays.sort(arr);
		int lcm = arr[0] * arr[1] / gcd(arr[0], arr[1]);

		for (int i = 1; i < arr.length; i++) {
			if (lcm < arr[i]) {
				lcm = lcm * arr[i] / gcd(lcm, arr[i]);
			} else {
				lcm = arr[i] * lcm / gcd(arr[i], lcm);
			}
		}
		return lcm;
	}

	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}