package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1662_ºñ¼ó {
	static int size;
	static int[][] map;
	static boolean[] slash;
	static boolean[] bSlash;
	static int cnt = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static int max;
	static int maxLength;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/////////////////////////////////////////////////////////////////////////
		maxLength = 2* size -1;
		slash = new boolean[maxLength];
		bSlash = new boolean[maxLength];
		dfs(0, 0);
		//////////////////////////////////////////////////////////////////////////
		System.out.println(max);
	}

	static void dfs(int row, int result) {
		if(maxLength - row + result <= max){
			return;
		}
		if (row == maxLength) {
			if (result > max) {
				max = result;
			}
			return;
		}
		if (row < size) {
			int loopCnt = row + 1;
			for (int i = 0; i < loopCnt; i++) {
				int newRow = row - i;
				if (map[newRow][i] == 1) {
					if (bSlash[size - 1 - newRow + i] == false) {
						bSlash[size - 1 - newRow + i] = true;
						dfs(row + 1, result + 1);
						bSlash[size - 1 - newRow + i] = false;
					} else if(i == loopCnt -1){
						dfs(row+1, result);
					}
				} else {
					if (i == loopCnt - 1) {
						dfs(row + 1, result);
					}
				}
			}
		} else {
			int loopStart = row - (size - 1);
			int newRow = size - 1;
			for (int col = loopStart; col < size; col++, newRow--) {
				if (map[newRow][col] == 1) {
					if (bSlash[size - 1 - newRow + col] == false) {
						bSlash[size - 1 - newRow + col] = true;
						dfs(row + 1, result + 1);
						bSlash[size - 1 - newRow + col] = false;
					} else if(col == size -1){
						dfs(row+1, result);
					}
				} else {
					if (col == size - 1) {
						dfs(row + 1, result);
					}
				}
			}
		}
	}
}
