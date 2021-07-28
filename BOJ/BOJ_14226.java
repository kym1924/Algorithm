import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {

	static class Emoji {
		int time;
		int copy;
		int emoji;

		Emoji(int time, int copy, int emoji) {
			this.time = time;
			this.copy = copy;
			this.emoji = emoji;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		bfs(S);
	}

	static void bfs(int S) {
		Queue<Emoji> q = new LinkedList<>();
		q.add(new Emoji(0, 0, 1));
		boolean[][] visited = new boolean[1001][1001];

		while (!q.isEmpty()) {
			Emoji now = q.poll();
			if (now.emoji == S) {
				System.out.println(now.time);
				break;
			}
			if (!visited[now.emoji][now.emoji]) {
				q.add(new Emoji(now.time + 1, now.emoji, now.emoji));
				visited[now.emoji][now.emoji] = true;
			}
			if (now.emoji != 1 && !visited[now.copy][now.emoji - 1]) {
				q.add(new Emoji(now.time + 1, now.copy, now.emoji - 1));
				visited[now.copy][now.emoji - 1] = true;
			}
			if (now.emoji + now.copy <= 1000 && !visited[now.copy][now.emoji + now.copy]) {
				q.add(new Emoji(now.time + 1, now.copy, now.emoji + now.copy));
				visited[now.copy][now.emoji + now.copy] = true;
			}
		}
	}
}
