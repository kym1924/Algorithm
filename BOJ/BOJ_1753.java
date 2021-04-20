import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BOJ_1753 {

	static int V, E, K;
	static int[] distance;
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		distance = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<Edge>());
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Edge(to, weight));
		}

		dijkstra();

		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			} else {
				bw.write(String.valueOf(distance[i]) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static void dijkstra() {
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[K] = 0;
		pq.add(new Edge(K, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited[edge.to]) {
				continue;
			} else {
				visited[edge.to] = true;
				for (Edge to : list.get(edge.to)) {
					if (distance[to.to] > distance[edge.to] + to.weight) {
						distance[to.to] = distance[edge.to] + to.weight;
						pq.add(new Edge(to.to, distance[to.to]));
					}
				}
			}
		}
	}
}
