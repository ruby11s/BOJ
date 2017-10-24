package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1661_πÃ∑Œ≈ª√‚∑Œ∫øbfs2 {
	static int garo;
	static int sero;
	static int[][] map;
	static ArrayList<Integer> list;
	static Queue<Co> q = new LinkedList<>();
	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int newX;
	static int newY;
	static Co start;
	static Co end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		garo = Integer.parseInt(st.nextToken());
		sero = Integer.parseInt(st.nextToken());
		map = new int[sero][garo];
		
		st = new StringTokenizer(br.readLine());
		int tempY = Integer.parseInt(st.nextToken());
		int tempX = Integer.parseInt(st.nextToken());
		int tempY2 = Integer.parseInt(st.nextToken());
		int tempX2 = Integer.parseInt(st.nextToken());
		start = new Co(tempX-1, tempY-1);
		end = new Co(tempX2-1, tempY2-1);
		
		for (int i = 0; i < sero; i++) {
			String str = br.readLine();
			for (int j = 0; j < garo; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		////////////////////////////////////////////////////////////////////////////
		
		System.out.println(bfs(start));
		////////////////////////////////////////////////////////////////////////////

	}

	static int bfs(Co start) {
		map[start.x][start.y] = 1;
		q.offer(start);
		while(!q.isEmpty()){
			Co co = q.poll();
			for(int i = 0 ; i <4 ; i ++){
				newX = co.x + dir[i][0];
				newY = co.y + dir[i][1];
				if(newX >= 0 && newY >= 0 && newX < sero && newY < garo
						&& map[newX][newY] == 0 ){
					if(newX == end.x && newY == end.y){
						return map[co.x][co.y];
					}
					map[newX][newY] = map[co.x][co.y]+1;
					q.offer(new Co(newX,newY));
				}
			}
		}
		return 0;
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
