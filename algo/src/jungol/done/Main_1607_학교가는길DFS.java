package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1607_학교가는길DFS {
	static int row;
	static int col;
	static int cnt;
	static int[][] map;
	static ArrayList<Integer> list;
	static int[][] dir = new int[][]{
			{0,1},{-1,0}
	};
	static int[] start = new int[2];
	static int[] dest = new int[2];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			map[row-temp2][temp1-1] = 1;
		}
		////////////////////////////////////////////////////////////////////////////
		start[0] = row-1;
		dest[1] = col-1;
		dfs(0, start[0], start[1]);
		System.out.println(result);
		
		////////////////////////////////////////////////////////////////////////////

	}// end main
	static void dfs(int level, int curX, int curY){
		if(level== row-1+col-1 + 1){
			return;
		}
		
		for(int i = 0 ; i < 2 ; i++){
			int newX = curX + dir[i][0];
			int newY = curY + dir[i][1];
			if(newX>=0 && newY>= 0 && newX < row && newY <col){
				if(map[newX][newY] == 0){
					if(newX == dest[0] && newY == dest[1]){
						result++;
						return;
					}
					dfs(level+1, newX, newY);
				}
			}
			
		}
	}
	

}// end class
