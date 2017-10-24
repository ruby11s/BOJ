package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1607_학교가는길DP {
	static int row;
	static int col;
	static int cnt;
	static int[][] map;
	static int[][] map2;
	static ArrayList<Integer> list;
	static int[][] dir = new int[][] { { 0, 1 }, { -1, 0 } };
	static int[] start = new int[2];
	static int[] dest = new int[2];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		map2 = new int[row][col];

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			map[row - temp2][temp1 - 1] = 1;
			map2[row - temp2][temp1 - 1] = -1;

		}
		////////////////////////////////////////////////////////////////////////////
		start[0] = row - 1;
		dest[1] = col - 1;
		map2[start[0]][start[1]] = 1;
		
//		for(int[] i : map){
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();
//		
		System.out.println(dp(dest[0], dest[1]));
//		for(int[] i : map2){
//			System.out.println(Arrays.toString(i));
//		}
		

		////////////////////////////////////////////////////////////////////////////

	}// end main

	static int dp(int curX, int curY) {
		int result1;
		int result2;

		// 왼쪽
		int newX = curX;
		int newY = curY - 1;
		if (newY >= 0) {
			if (map2[newX][newY] == 0) {
				result1 = dp(newX, newY);
			} else if (map2[newX][newY] == -1) {
				result1 = 0;
			} else {
				result1 = map2[newX][newY];
			}
		} else {
			result1 = 0;
		}

		// 아래
		newX = curX+1;
		newY = curY;
		if (newX < row) {
			if (map2[newX][newY] == 0) {
				result2 = dp(newX, newY);
			} else if (map2[newX][newY] == -1) {
				result2 = 0;
			} else {
				result2 = map2[newX][newY];
			}
		} else {
			result2 = 0;
		}
		map2[curX][curY] = result1+result2;
		return result1+result2;
	}

}// end class
