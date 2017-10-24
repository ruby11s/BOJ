package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1106_¿Â±‚ {
	static int row;
	static int col;
	static int[][] map;
	static ArrayList<Integer> list;
	static Queue<Co> q = new LinkedList<>();
	static int[][] dir = new int[][] { 	{ -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, 
										{ 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
	static int newX;
	static int newY;
	static Co mal;
	static Co jol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		st = new StringTokenizer(br.readLine());
		mal = new Co(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		jol = new Co(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

		/////////////////////////////////////////
		bfs(mal);
		/////////////////////////////////////////

	}

	static void bfs(Co start) {
		map[start.x][start.y] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			Co co = q.poll();
			for (int i = 0; i < 8; i++) {
				newX = co.x + dir[i][0];
				newY = co.y + dir[i][1];
				if (newX >= 0 && newY >= 0 && newX < row && newY < col 
						&& map[newX][newY] == 0) {
					if (newX == jol.x && newY == jol.y) {
						System.out.println(map[co.x][co.y]);
					}
					map[newX][newY] = map[co.x][co.y] + 1;
					q.offer(new Co(newX, newY));
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
