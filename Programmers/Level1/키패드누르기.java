class Solution {
	static Point[] phone = new Point[12];

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void makePhone() {
		phone[0] = new Point(3, 1);
		phone[1] = new Point(0, 0);
		phone[2] = new Point(0, 1);
		phone[3] = new Point(0, 2);
		phone[4] = new Point(1, 0);
		phone[5] = new Point(1, 1);
		phone[6] = new Point(1, 2);
		phone[7] = new Point(2, 0);
		phone[8] = new Point(2, 1);
		phone[9] = new Point(2, 2);
		phone[10] = new Point(3, 0);
		phone[11] = new Point(3, 2);
	}

	static int getLeftDist(int num, int left) {
		return Math.abs(phone[left].x - phone[num].x) + Math.abs(phone[left].y - phone[num].y);
	}

	static int getRightDist(int num, int right) {
		return Math.abs(phone[right].x - phone[num].x) + Math.abs(phone[right].y - phone[num].y);
	}

	public String solution(int[] numbers, String hand) {
		makePhone();

		int left = 10, right = 11;
		StringBuilder sb = new StringBuilder();
		for (int num : numbers) {
			if (num == 1 || num == 4 || num == 7) {
				left = num;
				sb.append('L');
			} else if (num == 3 || num == 6 || num == 9) {
				right = num;
				sb.append('R');
			} else {
				int leftDist = getLeftDist(num, left);
				int rightDist = getRightDist(num, right);
				if (leftDist > rightDist) {
					right = num;
					sb.append('R');
				} else if (leftDist < rightDist) {
					left = num;
					sb.append('L');
				} else {
					if (hand.equals("right")) {
						right = num;
						sb.append('R');
					} else if (hand.equals("left")) {
						left = num;
						sb.append('L');
					}
				}
			}
		}
		return sb.toString();
	}
}