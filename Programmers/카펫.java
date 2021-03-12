class Solution {
	public int[] solution(int brown, int yellow) {
		int total = brown + yellow;
		int[] answer = new int[2];
		for (int i = 1; i <= total / 2; i++) {
			if (total % i == 0) {
				int width = i;
				int height = total / width;
				if (width >= height) {
					if ((width * 2) + (height * 2) - 4 == brown) {
						if (width * height == total) {
							answer[0] = width;
							answer[1] = height;
						}
					}
				}
			}
		}
		return answer;
	}
}