package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1840_ДЎБо {

	static int[][] map;
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int oneCnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				int tempNum = Integer.parseInt(st.nextToken());
				if(tempNum == 1) oneCnt++;
				map[i][j] = tempNum;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		int count = 2;
		while(oneCnt>0){
			Co first = new Co(0, 0, count);
			map[0][0] = count;
			Queue<Co> q = new LinkedList<>();
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
					if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
						if(map[newX][newY] == 0){
							map[newX][newY] = count;
							q.offer(new Co(newX, newY, co.cnt + 1));
						} else if(map[newX][newY] == 1){
							map[newX][newY] = count;
							oneCnt--;
						}
					}
				}
			}
			for(int i = 0 ; i < row ; i++){
				for(int j = 0 ; j < col ; j++){
					if(map[i][j] == count) map[i][j] = 0;
				}
			}
			list.add(oneCnt);
			count++;
		}
		
		System.out.println(count-2);
		System.out.println(list.get(list.size()-2));

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
