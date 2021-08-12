class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				answer[i] = oddCheck(numbers[i]);
			}
		}
		return answer;
	}

	static long oddCheck(long n) {
		StringBuilder sb = new StringBuilder(Long.toBinaryString(n));
		int lastZeroIndex = sb.lastIndexOf("0");
		int lastOneIndex = lastZeroIndex + 1;
		if (lastZeroIndex == -1) {
			sb.insert(0, '1');
			lastOneIndex += 1;
		} else {
			sb.setCharAt(lastZeroIndex, '1');
		}
		sb.setCharAt(lastOneIndex, '0');
		return Long.parseLong(sb.toString(), 2);
	}
}