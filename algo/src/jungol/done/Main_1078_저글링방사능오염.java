package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1078_저글링방사능오염 {

	static int[][] map;
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			String temp = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(temp.charAt(j) + "");
			}
		}

		st = new StringTokenizer(br.readLine());
		int fcol = Integer.parseInt(st.nextToken());
		int frow = Integer.parseInt(st.nextToken());
		Co first = new Co(frow - 1, fcol - 1, 3);

		Queue<Co> q = new LinkedList<>();
		map[first.x][first.y] = first.cnt;
		q.offer(first);
		while (!q.isEmpty()) {
			Co co = q.poll();
			int x = co.x;
			int y = co.y;
			int newX;
			int newY;
			for (int i = 0; i < 4; i++) {
				newX = x + dir[i][0];
				newY = y + dir[i][1];
				if (newX >= 0 && newX < row && newY >= 0 && newY < col 
						&& map[newX][newY] == 1) {
					map[newX][newY] = co.cnt + 1;
					q.offer(new Co(newX, newY, co.cnt + 1));
				}
			}
		}

		int max = 3;
		int not = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 1)
					not++;
				if (map[i][j] >= 3 && map[i][j] > max) {
					max = map[i][j];
				}
			}
		}
		System.out.println(max);
		System.out.println(not);

	}

	static class Co {
		int x;
		int y;
		int cnt;

		public Co(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Co [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append(", cnt=");
			builder.append(cnt);
			builder.append("]");
			return builder.toString();
		}

	}
}
