package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1733_¿À¸ñ {
	static int[][] map;
	static ArrayList<Integer> list;
	static final int[] UP = { -1, 0 };
	static final int[] DOWN = { 1, 0 };
	static final int[] LEFT = { 0, -1 };
	static final int[] RIGHT = { 0, 1 };
	static final int[] UPLEFT = { -1, -1 };
	static final int[] UPRIGHT = { -1, 1 };
	static final int[] DOWNLEFT = { 1, -1 };
	static final int[] DOWNRIGHT = { 1, 1 };
	static int newX;
	static int newY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[19][19];

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		////////////////////////////////////////////////////////////////////////////

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					int bw = map[i][j];
					Co temp = new Co(i, j, bw);
					int resultX = temp.x;
					int resultY = temp.y;

					if (temp.y + LEFT[1] >= 0 
							&& map[temp.x + LEFT[0]][temp.y + LEFT[1]] != bw) {
						int k;
						for (k = 0; k < 5; k++) {
							if (temp.y + RIGHT[1] < 19 
									&& map[temp.x + RIGHT[0]][temp.y + RIGHT[1]] == bw) {
								temp.x += RIGHT[0];
								temp.y += RIGHT[1];
							} else
								break;
						}
						if (k == 4) {
							System.out.println(bw);
							System.out.println((resultX + 1) + " " + (resultY + 1));
							return;
						}
					}
					temp.x = resultX;
					temp.y = resultY;

					if (temp.x + UPLEFT[0] >= 0 && temp.y + UPLEFT[1] >= 0
							&& map[temp.x + UPLEFT[0]][temp.y + UPLEFT[1]] != bw) {
						int k;
						for (k = 0; k < 5; k++) {
							if (temp.x + DOWNRIGHT[0] < 19 && temp.y + DOWNRIGHT[1] < 19
									&& map[temp.x + DOWNRIGHT[0]][temp.y + DOWNRIGHT[1]] == bw) {
								temp.x += DOWNRIGHT[0];
								temp.y += DOWNRIGHT[1];
							} else
								break;
						}
						if (k == 4) {
							System.out.println(bw);
							System.out.println((resultX + 1) + " " + (resultY + 1));
							return;
						}
					}
					temp.x = resultX;
					temp.y = resultY;

					if (temp.x == 0 || (temp.x + UP[0] >= 0 
							&& map[temp.x + UP[0]][temp.y + UP[1]] != bw)) {
						int k;
						for (k = 0; k < 5; k++) {
							if (temp.x + DOWN[0] < 19
									&& map[temp.x + DOWN[0]][temp.y + DOWN[1]] == bw) {
								temp.x += DOWN[0];
								temp.y += DOWN[1];
							} else
								break;
						}
						if (k == 4) {
							System.out.println(bw);
							System.out.println((resultX + 1) + " " + (resultY + 1));
							return;
						}
					}
					temp.x = resultX;
					temp.y = resultY;

					if (temp.x + UPRIGHT[0] >= 0 && temp.y + UPRIGHT[1] < 19
							&& map[temp.x + UPRIGHT[0]][temp.y + UPRIGHT[1]] != bw) {
						int k;
						for (k = 0; k < 5; k++) {
							if (temp.x + DOWNLEFT[0] < 19 && temp.y + DOWNLEFT[1] >=0
									&& map[temp.x + DOWNLEFT[0]][temp.y + DOWNLEFT[1]] == bw) {
								temp.x += DOWNLEFT[0];
								temp.y += DOWNLEFT[1];
							} else
								break;
						}
						if (k == 4) {
							System.out.println(bw);
							System.out.println((temp.x + 1) + " " + (temp.y + 1));
							return;
						}
					}
				}
			}
		}
		
		System.out.println(0);
		
		
		////////////////////////////////////////////////////////////////////////////

	}// end main

	static class Co {
		int x;
		int y;
		int bw;

		public Co(int x, int y, int bw) {
			super();
			this.x = x;
			this.y = y;
			this.bw = bw;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Co [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append(", bw=");
			builder.append(bw);
			builder.append("]");
			return builder.toString();
		}

	}

}// end class
