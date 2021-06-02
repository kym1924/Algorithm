import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_8972 {

	static int R, C;
	static int myR = 0, myC = 0;
	static int[] offsetX = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] offsetY = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static char[][] board;
	static int[][] count;
	static int result = 0;

	static class Arduino {
		int r;
		int c;

		Arduino(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		board = new char[R][C];

		Queue<Arduino> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'R') {
					q.add(new Arduino(i, j));
				} else if (board[i][j] == 'I') {
					myR = i;
					myC = j;
				}
			}
		}

		String move = br.readLine();
		for (int i = 0; i < move.length(); i++) {
			char now = move.charAt(i);
			if (now != 5) {
				if (!move(Character.getNumericValue(now))) {
					bw.write("kraj " + result);
					bw.flush();
					bw.close();
					return;
				}
			}

			int size = q.size();
			count = new int[R][C];

			for (int j = 0; j < size; j++) {
				Arduino a = q.poll();
				board[a.r][a.c] = '.';
				int direction = arduinoMove(a.r, a.c);
				int arduinoR = a.r + offsetX[direction];
				int arduinoC = a.c + offsetY[direction];
				if (board[arduinoR][arduinoC] == 'I') {
					bw.write("kraj " + result);
					bw.flush();
					bw.close();
					return;
				} else {
					count[arduinoR][arduinoC]++;
				}
			}

			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if (count[j][k] == 1) {
						q.add(new Arduino(j, k));
						board[j][k] = 'R';
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bw.write(board[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static boolean move(int direction) {
		result++;
		board[myR][myC] = '.';
		myR += offsetX[direction - 1];
		myC += offsetY[direction - 1];
		if (board[myR][myC] == 'R') {
			return false;
		}
		board[myR][myC] = 'I';
		return true;
	}

	static int arduinoMove(int r, int c) {
		int distance = Integer.MAX_VALUE;
		int direction = -1;
		for (int i = 0; i < 9; i++) {
			if (i == 4) {
				continue;
			}
			int tempR = r + offsetX[i];
			int tempC = c + offsetY[i];
			if (tempR >= 0 && tempR < R && tempC >= 0 && tempC < C) {
				int temp = distance(tempR, tempC);
				if (distance > temp) {
					distance = temp;
					direction = i;
				}
			}
		}
		return direction;
	}

	static int distance(int r, int c) {
		return Math.abs(r - myR) + Math.abs(c - myC);
	}
}
