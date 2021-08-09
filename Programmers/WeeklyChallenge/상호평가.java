
public class T {

	public static void main(String[] args) throws Exception {
		int[][] scores = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
				{ 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < scores.length; i++) {
			int count = scores.length;
			int sum = 0, max = scores[i][i], min = scores[i][i], maxIndex = i, minIndex = i;
			for (int j = 0; j < scores.length; j++) {
				sum += scores[j][i];
				if (max > scores[j][i]) {
					maxIndex = j;
				}
				if (min < scores[j][i]) {
					minIndex = j;
				}
			}
			if (maxIndex == i || minIndex == i) {
				count -= 1;
				sum -= scores[i][i];
			}
			System.out.println((double) (sum / count));
			sb.append(grade(sum / count));
		}
	}

	static String grade(double avg) {
		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 50) {
			return "D";
		}
		return "F";
	}
}