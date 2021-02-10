import java.util.Arrays;
import java.util.Collections;

class Solution {
	public int solution(int n) {
		int answer = 0;
		int count = 0;

		for (int i = 1; i <= n; i *= 3) {
			count++;
		}

		Integer[] arr = new Integer[count];

		count = 0;
		for (int i = 1; i <= n; i *= 3) {
			arr[count++] = i;
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int temp = n;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(temp / arr[i]);
			temp = temp % arr[i];
		}

		sb.reverse();

		temp = sb.toString().length() - 1;
		for (int i = 1; i <= n; i *= 3) {
			answer += i * Character.getNumericValue(sb.toString().charAt(temp--));
		}

		return answer;
	}
}