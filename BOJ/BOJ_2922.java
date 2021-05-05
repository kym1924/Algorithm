import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2922 {

	static char[] word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toCharArray();
		System.out.println(dfs(0, 0, 0, false));
	}

	static long dfs(int index, int vowel, int consonant, boolean l) {
		long answer = 0;

		if (vowel >= 3 || consonant >= 3) {
			return 0;
		}
		if (index == word.length) {
			if (l) {
				return 1;
			}
			return 0;
		}
		if (word[index] == '_') {
			answer += 5 * (dfs(index + 1, vowel + 1, 0, l));
			answer += 20 * (dfs(index + 1, 0, consonant + 1, l));
			answer += (dfs(index + 1, 0, consonant + 1, true));
		} else if (isVowel(word[index])) {
			answer += dfs(index + 1, vowel + 1, 0, l);
		} else if (!isVowel(word[index])) {
			if (word[index] == 'L') {
				answer += dfs(index + 1, 0, consonant + 1, true);
			} else {
				answer += dfs(index + 1, 0, consonant + 1, l);
			}
		}
		return answer;
	}

	static boolean isVowel(char alphabet) {
		if (alphabet == 'A' || alphabet == 'E' || alphabet == 'I' || alphabet == 'O' || alphabet == 'U') {
			return true;
		}
		return false;
	}
}