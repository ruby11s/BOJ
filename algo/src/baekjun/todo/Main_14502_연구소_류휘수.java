package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_류휘수 {
	static int[][] map;
	static int row;
	static int col;
	static int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int max = Integer.MIN_VALUE;
	static boolean[][] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////
		wall(0, 0, 0);
		System.out.println(max);

		////////////////////////////////////////////

	}// end main
	
	private static void wall(int level, int x, int y){
		if(level == 3){
			int[][] newMap = new int[row][col];
			for(int i = 0 ; i < row ; i++){
				for(int j = 0 ; j < col ; j++){
					newMap[i][j] = map[i][j];
				}
			}
			bfs(newMap);
			return;
		}
		for(int i = x ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(i == x && j < y){
					continue;
				}
				if(map[i][j] == 0){
					map[i][j] = 1;
					wall(level+1, i, j);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(int[][] newMap) {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(map[i][j] == 2){
					queue.offer(new int[]{i, j});
				}
			}
		}
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int newX;
			int newY;
			for(int i = 0 ; i < 4 ; i++){
				newX = cur[0] + dir[i][0];
				newY = cur[1] + dir[i][1];
				if(newX>=0 && newY>= 0 && newX<row && newY <col
						&& newMap[newX][newY] == 0){
					newMap[newX][newY] = 2;
					queue.offer(new int[]{newX, newY});
				}
			}
		}
		int count = 0;
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(newMap[i][j] == 0){
					count++;
				}
			}
		}
		if(count > max){
			max = count;
		}
		
	}

}// end class