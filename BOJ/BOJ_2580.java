import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2580 {

	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sudoku(0);
	}

	static void sudoku(int count) throws Exception {
		if (count == 81) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.write(String.valueOf(sudoku[i][j]) + " ");
				}
				bw.write("\n");
			}
			bw.flush();
			bw.close();
			System.exit(0);
		}

		int row = count / 9;
		int col = count % 9;
		if (sudoku[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (horizontal(row, i) && vertical(col, i)) {
					if (square((row / 3) * 3, (col / 3) * 3, i)) {
						sudoku[row][col] = i;
						sudoku(count + 1);
					}
				}
			}
			sudoku[row][col] = 0;
		} else {
			sudoku(count + 1);
		}
	}

	static boolean horizontal(int row, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean vertical(int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean square(int startRow, int startCol, int num) {
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
