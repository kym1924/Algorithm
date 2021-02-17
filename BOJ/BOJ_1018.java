import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1018 {
	static int N, M;
	static int startX, startY;
	static int answer = Integer.MAX_VALUE;
	static char[][] chess;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		chess = new char[N][M];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				chess[i][j] = temp[j].charAt(0);
			}
		}

		startX = N - 7;
		startY = M - 7;

		for (int i = 0; i < startX; i++) {
			for (int j = 0; j < startY; j++) {
				findB(i, j);
				findW(i, j);
			}
		}

		System.out.print(answer);
	}

	static void findB(int x, int y) {
		int count = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if ((i + j) % 2 == 0 && chess[i][j] != 'B') {
					count++;
				}
				if ((i + j) % 2 == 1 && chess[i][j] != 'W') {
					count++;
				}
			}
		}
		answer = Math.min(answer, count);
	}

	static void findW(int x, int y) {
		int count = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if ((i + j) % 2 == 0 && chess[i][j] != 'W') {
					count++;
				}
				if ((i + j) % 2 == 1 && chess[i][j] != 'B') {
					count++;
				}
			}
		}
		answer = Math.min(answer, count);
	}
}