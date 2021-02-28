import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {

	static int N, M, trueCount, answer;
	static int[] parent;
	static ArrayList<Integer> truePerson = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> party = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		init();

		st = new StringTokenizer(br.readLine());
		trueCount = Integer.parseInt(st.nextToken());
		for (int i = 0; i < trueCount; i++) {
			truePerson.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < M; i++) {
			int a = party.get(i).get(0);
			for (int j = 1; j < party.get(i).size(); j++) {
				int b = party.get(i).get(j);
				union(a, b);
			}
		}

		for (int i = 0; i < M; i++) {
			boolean check = true;
			for (int j = 0; j < party.get(i).size(); j++) {
				if (!check) {
					break;
				}
				int a = party.get(i).get(j);
				for (int k = 0; k < truePerson.size(); k++) {
					int b = truePerson.get(k);
					if (sameCheck(a, b)) {
						check = false;
						break;
					}

				}
			}
			if (!check) {
				answer--;
			}
		}

		System.out.print(answer);
	}

	static void init() {
		answer = M;
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			party.add(new ArrayList<Integer>());
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[b] = a;
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return find(parent[a]);
		}
	}

	static boolean sameCheck(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}
}
