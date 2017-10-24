package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2613_≈‰∏∂≈‰ {
	static int garo;
	static int sero;
	static int[][] map;
	static ArrayList<Integer> list;
	static Queue<Co> q = new LinkedList<>();
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int newX;
	static int newY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		garo = Integer.parseInt(st.nextToken());
		sero = Integer.parseInt(st.nextToken());
		map = new int[sero][garo];
		
		for (int i = 0; i < sero; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < garo; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////////////////////////////////////
		bfs();
		int max = -1;
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if(map[i][j] > max){
					max = map[i][j];
				}
			}
		}
		if(max == 1) {
			System.out.println(0);
			return;
		} else{
			for (int i = 0; i < sero; i++) {
				for (int j = 0; j < garo; j++) {
					if(map[i][j] == 0){
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(max-1);
		}
		
		////////////////////////////////////////////////////////////////////////////

	}

	static void bfs() {
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if(map[i][j] == 1){
					q.offer(new Co(i, j));
				}
			}
		}
		
		while(!q.isEmpty()){
			Co co = q.poll();
			for(int i = 0 ; i <4 ; i ++){
				newX = co.x + dir[i][0];
				newY = co.y + dir[i][1];
				if(newX >= 0 && newY >= 0 && newX < sero && newY < garo
						&& map[newX][newY] == 0){
					map[newX][newY] = map[co.x][co.y]+1;
					q.offer(new Co(newX,newY));
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
