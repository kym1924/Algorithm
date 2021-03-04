import java.util.ArrayList;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Integer> budget = new ArrayList<>();
		
		for (int i = 0; i < moves.length; i++) {
			int crain = moves[i] - 1;
			for (int j = 0; j < board[0].length; j++) {
				if (board[j][crain] != 0) {
					budget.add(board[j][crain]);
					if (budget.size() >= 2) {
						if (budget.get(budget.size() - 2) == budget.get(budget.size() - 1)) {
							budget.remove(budget.size() - 2);
							budget.remove(budget.size() - 1);
							answer += 2;
						}
					}
					board[j][crain] = 0;
					break;
				}
			}
		}
		
		return answer;
	}
}