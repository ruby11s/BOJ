package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1462_º¸¹°¼¶ {
	static int row;
	static int col;
	static int[][] map;
	static ArrayList<Integer> list;
	static Queue<Co> q = new LinkedList<>();
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] newMap;
	static int newX;
	static int newY;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		newMap = new int[row][col];
		for (int i = 0; i < row; i++) {
			String temp = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = (temp.charAt(j) == 'W') ? 1 : 0;
			}
		}
		/////////////////////////////////////////
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0) {
					bfs(new Co(i, j));
				}
			}
		}

		/////////////////////////////////////////
		System.out.println(max - 1);

	}

	static void bfs(Co start) {
		for (int i = 0; i < row; i++) {
			for(int j = 0 ; j < col ;j++){				
				newMap[i][j] = map[i][j];
			}
		}
		q.offer(start);
		newMap[start.x][start.y] = 1;
		while (!q.isEmpty()) {
			Co co = q.poll();
			int num = newMap[co.x][co.y];
			for (int i = 0; i < 4; i++) {
				newX = co.x + dir[i][0];
				newY = co.y + dir[i][1];
				if (newX >= 0 && newY >= 0 && newX < row && newY < col
						&& (newMap[newX][newY] == 0 || num + 1 < newMap[newX][newY])) {
					newMap[newX][newY] = num + 1;
					q.offer(new Co(newX, newY));
					if (num + 1 > max) {
						max = num + 1;
					}
				}
			}
		}

	}

	static class Co {
		int x;
		int y;

		public Co(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Co [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
	}
}
