class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (!skill.contains(skill_trees[i].substring(j, j + 1))) {
					skill_trees[i] = skill_trees[i].replace(skill_trees[i].substring(j, j + 1), "");
					j--;
				}
			}
			int index = 0;
			boolean check = true;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (skill.charAt(index) == skill_trees[i].charAt(j)) {
					index++;
				} else {
					check = false;
					break;
				}
			}
			if (check) {
				answer++;
			}
		}
		return answer;
	}
}