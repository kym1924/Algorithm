import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2887 {

	static int N;
	static int[] parent;
	static ArrayList<Planet> list = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static class Planet {
		int index;
		int x;
		int y;
		int z;

		Planet(int index, int x, int y, int z) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Planet(i, x, y, z));
			parent[i] = i;
		}

		getXEdges();
		getYEdges();
		getZEdges();
		kruskal();
	}

	static void getXEdges() {
		Collections.sort(list, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return Integer.compare(p1.x, p2.x);
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = list.get(i);
			Planet p2 = list.get(i + 1);
			pq.add(new Edge(p1.index, p2.index, Math.abs(p1.x - p2.x)));
		}
	}

	static void getYEdges() {
		Collections.sort(list, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return Integer.compare(p1.y, p2.y);
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = list.get(i);
			Planet p2 = list.get(i + 1);
			pq.add(new Edge(p1.index, p2.index, Math.abs(p1.y - p2.y)));
		}
	}

	static void getZEdges() {
		Collections.sort(list, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return Integer.compare(p1.z, p2.z);
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = list.get(i);
			Planet p2 = list.get(i + 1);
			pq.add(new Edge(p1.index, p2.index, Math.abs(p1.z - p2.z)));
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[b] = a;
	}

	static void kruskal() {
		int sum = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (find(now.from) != find(now.to)) {
				union(now.from, now.to);
				sum += now.weight;
			}
		}
		System.out.print(sum);
	}
}
