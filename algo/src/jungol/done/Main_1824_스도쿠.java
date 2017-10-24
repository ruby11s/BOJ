package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1824_½ºµµÄí {

	static int[][] map;
	static ArrayList<int[]> zeroList = new ArrayList<>();
	static boolean finished;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeroList.add(new int[] { i, j });
				}
			}
		}
		/////////////////////////////////////
		dfs(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		////////////////////////////////
	}

	static void dfs(int level) {
		if (level == zeroList.size()) {
			finished = true;
			return;
		}
		
		int row = zeroList.get(level)[0];
		int col = zeroList.get(level)[1];
		ArrayList<Integer> check = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			check.add(i);
		}
		// row, col check
		for (int i = 0; i < 9; i++) {
			if (map[row][i] != 0) {
				check.remove(new Integer(map[row][i]));
			}
			if (map[i][col] != 0) {
				check.remove(new Integer(map[i][col]));
			}
		}
		// box check
		int boxRow = (row / 3) * 3;
		int boxCol = (col / 3) * 3;
		for (int i = boxRow; i < boxRow + 3; i++) {
			for (int j = boxCol; j < boxCol + 3; j++) {
				if (map[i][j] != 0) {
					check.remove(new Integer(map[i][j]));
				}
			}
		}

		for (int i = 0; i < check.size(); i++) {
			map[row][col] = check.get(i);
			dfs(level + 1);
			if(finished) break;
			map[row][col] = 0;
		}

	}
}
