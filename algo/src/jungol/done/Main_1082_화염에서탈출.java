package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1082_»≠ø∞ø°º≠≈ª√‚ {
	static int row;
	static int col;
	static char[][] map;
	static int[] d;
	static int[] s;
	static int[] f;
	static ArrayList<int[]> flist = new ArrayList<>();
	static Queue<Fire> q = new LinkedList<>();
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];

		for (int i = 0; i < row; i++) {
			String temp = br.readLine();
			for (int j = 0; j < col; j++) {
				char ch = temp.charAt(j);
				if (ch == 'D') {
					d = new int[] { i, j };
				}
				if (ch == 'S') {
					s = new int[] { i, j };
				}
				if (ch == '*') {
					f = new int[] { i, j };
					flist.add(f);
				}
				map[i][j] = ch;
			}
		}
		////////////////////////////////////////////////////////////////////////////
		if (flist.size()>0) {
			for(int[] fs : flist){
				q.offer(new Fire(fs[0], fs[1]));
			}
		}
		if (s != null) {
			q.offer(new Sup(s[0], s[1], 0));
		}

		int x;
		int y;
		int newX;
		int newY;
		while (!q.isEmpty()) {
			
			Fire fire = q.poll();
			x = fire.x;
			y = fire.y;
			for (int i = 0; i < 4; i++) {
				newX = x + dir[i][0];
				newY = y + dir[i][1];
				if (newX >= 0 && newY >= 0 && newX < row && newY < col) {
					if (fire instanceof Sup) {
						if (map[newX][newY] == '.' || map[newX][newY] == 'D') {
							if (map[newX][newY] == 'D') {
								System.out.println(((Sup) fire).cnt + 1);
								return;
							}
							map[newX][newY] = 'S';
							q.offer(new Sup(newX, newY, ((Sup) fire).cnt + 1));
						}
					} else {
						if (map[newX][newY] == '.' || map[newX][newY] == 'S') {
							map[newX][newY] = '*';
							q.offer(new Fire(newX, newY));
						}
					}
				}
			}

		}
		System.out.println("impossible");

		////////////////////////////////////////////////////////////////////////////

	}// end main

	static class Fire {
		int x;
		int y;

		public Fire(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Fire [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
	}

	static class Sup extends Fire {
		int cnt;

		public Sup(int x, int y) {
			super(x, y);
		}

		public Sup(int x, int y, int cnt) {
			super(x, y);
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Sup [cnt=");
			builder.append(cnt);
			builder.append(", x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
	}

}// end class
