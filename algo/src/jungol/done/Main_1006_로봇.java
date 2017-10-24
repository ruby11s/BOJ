package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1006_·Îº¿ {
	static int row, col;
	static int[][] map;
	static ArrayList<Integer> list;
	static Queue<Co> q = new LinkedList<>();
	static int[][] dir = new int[][] { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int startX, startY, startDir;
	static int endX, endY, endDir;
	static int newX, newY;
	static final int EAST = 1;
	static final int WEST = 2;
	static final int SOUTH = 3;
	static final int NORTH = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken()) - 1;
		startY = Integer.parseInt(st.nextToken()) - 1;
		startDir = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		endX = Integer.parseInt(st.nextToken()) - 1;
		endY = Integer.parseInt(st.nextToken()) - 1;
		endDir = Integer.parseInt(st.nextToken());
		/////////////////////////////////////////
		if(startX == endX && startY == endY){
			if (startDir != endDir) {
				int temp = Math.abs(startDir - endDir);
				if (temp == 3 || temp == 2)
					System.out.println(1);
				else if (temp == 1) {
					int temp2 = Math.min(startDir, endDir);
					if (temp2 == 1 || temp2 == 3)
						System.out.println(2);
					else
						System.out.println(1);
				}
			} else {
				System.out.println(0);
			}
			return;
		}
		bfs(new Co(startX, startY, startDir, 1));

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}

		/////////////////////////////////////////
		System.out.println(map[endX][endY] - 1);
	}

	static void bfs(Co start) {
		map[start.x][start.y] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			Co co = q.poll();
			for (int i = 1; i < 5; i++) {
				for (int j = 1; j <= 3; j++) {
					int newCnt = 0;
					int newDir = 0;
					newX = co.x + dir[i][0] * j;
					newY = co.y + dir[i][1] * j;
					if (newX >= 0 && newY >= 0 && newX < row && newY < col) {
						if (co.toward == i) {
							newCnt = co.cnt + 1;
						} else if (i == EAST || i == WEST) {
							if (co.toward == EAST || co.toward == WEST) {
								newCnt = co.cnt + 3;
							} else {
								newCnt = co.cnt + 2;
							}
						} else if (i == NORTH || i == SOUTH) {
							if (co.toward == NORTH || co.toward == SOUTH) {
								newCnt = co.cnt + 3;
							} else {
								newCnt = co.cnt + 2;
							}
						}
						newDir = i;

						if (newX == endX && newY == endY) {
							if (newDir != endDir) {
								int temp = Math.abs(newDir - endDir);
								if (temp == 3 || temp == 2)
									newCnt++;
								else if (temp == 1) {
									int temp2 = Math.min(newDir, endDir);
									if (temp2 == 1 || temp2 == 3)
										newCnt = newCnt + 2;
									else
										newCnt++;
								}
							}
						}
						
						if(j >= 2 ){
							if(map[newX-dir[i][0]][newY-dir[i][1]] == 1) continue;
							if(j == 3){
								if(map[newX-dir[i][0]*2][newY-dir[i][1]*2] == 1) continue;
							}
						}
						
						if (map[newX][newY] == 0 || map[newX][newY] > newCnt) {
							map[newX][newY] = newCnt;
							q.offer(new Co(newX, newY, newDir, newCnt));
						}
					}
				}
			}
		}
	}

	static class Co {
		int x;
		int y;
		int toward;
		int cnt;

		public Co(int x, int y, int toward, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.toward = toward;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Co [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append(", toward=");
			builder.append(toward);
			builder.append(", cnt=");
			builder.append(cnt);
			builder.append("]");
			return builder.toString();
		}

	}
}
