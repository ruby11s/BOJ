package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1238_¹Ì·ÎÅ»Ãâ·Îº¿Áß°£´Ü°è_·ùÈÖ¼ö {
	static int n;
	static int[][] map;
	static int[][] dir = new int[][] { { 0, 0 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		String temp;
		for (int i = 0; i < n; i++) {
			temp = br.readLine().trim();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(temp.charAt(j) + "");
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		int[] direction = new int[4];
		for (int i = 0; i < 4; i++) {
			direction[i] = Integer.parseInt(st.nextToken());
		}
		////////////////////////////////////////////////////////////////////////////
		int curX = 0;
		int curY = 0;
		map[curX][curY] = 1;
		int newX;
		int newY;
		int checkX;
		int checkY;
		int checkDir;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int curDir = direction[i];
			while (true) {
				newX = curX + dir[curDir][0];
				newY = curY + dir[curDir][1];
				if (newX >= 0 && newY >= 0 && newX < n && newY < n && map[newX][newY] == 0) {
					map[newX][newY] = cnt;
					curX = newX;
					curY = newY;
					cnt++;
//					for (int m = 0; m < n; m++) {
//						for (int k = 0; k < n; k++) {
//							System.out.printf("%3d", map[m][k]);
//						}
//						System.out.println();
//					}
//					System.out.println("======" + cnt + "======");
				} else {
					break;
				}
			}
			if (i == 3) {
				boolean fin = true;
				checkDir = direction[0];
				checkX = curX + dir[checkDir][0];
				checkY = curY + dir[checkDir][1];
				if (checkX >= 0 && checkY >= 0 && checkX < n && checkY < n && map[checkX][checkY] == 0) {
					fin = false;
				}
				if (fin) {
					break;
				} else {
					i = -1;
				}
			}
		}
		System.out.println(cnt);

		////////////////////////////////////////////////////////////////////////////

	}// end main

}// end class
