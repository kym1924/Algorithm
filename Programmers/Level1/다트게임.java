import java.util.Arrays;

class Solution {
	public int solution(String dartResult) {
		int[] score = new int[3];
		int scoreIndex = 0;
		char[] charArr = dartResult.toCharArray();

		for (int i = 0; i < charArr.length; i++) {

			char now = charArr[i];
			int nowScore = Character.getNumericValue(now);

			if (0 <= nowScore && nowScore <= 9) {
				if (nowScore == 1 && Character.getNumericValue(charArr[i + 1]) == 0) {
					nowScore = 10;
					i++;
				}
				score[scoreIndex++] = nowScore;
			}

			if (now == 'S') {
				score[scoreIndex - 1] = (int) Math.pow(score[scoreIndex - 1], 1);
			} else if (now == 'D') {
				score[scoreIndex - 1] = (int) Math.pow(score[scoreIndex - 1], 2);
			} else if (now == 'T') {
				score[scoreIndex - 1] = (int) Math.pow(score[scoreIndex - 1], 3);
			}

			if (now == '*') {
				if (scoreIndex >= 2) {
					score[scoreIndex - 2] *= 2;
				}
				score[scoreIndex - 1] *= 2;
			} else if (now == '#') {
				score[scoreIndex - 1] *= -1;
			}
		}

		return Arrays.stream(score).sum();

	}
}