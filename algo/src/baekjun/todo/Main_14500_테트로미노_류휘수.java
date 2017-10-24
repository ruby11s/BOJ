package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노_류휘수 {
	static int[][] map;
	static int row;
	static int col;
	static int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int max = Integer.MIN_VALUE;
	static boolean[][] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		checked = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dfs(0, i, j, 0);
				fuck(i, j);
			}
		}

		System.out.println(max);

		////////////////////////////////////////////

	}// end main

	static void dfs(int level, int x, int y, int sum) {
		checked[x][y] = true;
		sum += map[x][y];
		if (level == 3) {
			if (sum > max) {
				max = sum;
			}
			checked[x][y] = false;
			sum -= map[x][y];
			return;
		}
		int newX;
		int newY;
		for (int i = 0; i < 4; i++) {
			newX = x + dir[i][0];
			newY = y + dir[i][1];
			if (newX >= 0 && newY >= 0 && newX < row && newY < col && !checked[newX][newY]) {
				dfs(level + 1, newX, newY, sum);
			}
		}
		checked[x][y] = false;
		sum -= map[x][y];
	}

	static void fuck(int x, int y) {
		int newX;
		int newY;
		int sum;
		boolean flag = true;
		for (int j = 0; j < 4; j++) {
			flag = true;
			sum = map[x][y];
			for (int i = 0; i < 4; i++) {
				if(j == i ) continue;
				newX = x + dir[i][0];
				newY = y + dir[i][1];
				if (newX >= 0 && newY >= 0 && newX < row && newY < col) {
					sum += map[newX][newY];
				} else {
					flag = false;
					break;
				}
			}
			if(flag){
				if( sum > max){
					max = sum;
				}
			}
		}
	}
}// end class