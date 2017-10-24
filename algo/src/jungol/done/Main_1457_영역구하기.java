package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_1457_영역구하기 {

	static int cnt;
	static int[][] map;
	static int[][] dir = new int[][]{
		{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};
	static int row;
	static int col;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for(int i = 0 ; i < cnt ; i++){
			st = new StringTokenizer(br.readLine());
			int colS = Integer.parseInt(st.nextToken());
			int rowS = Integer.parseInt(st.nextToken());
			int colE = Integer.parseInt(st.nextToken());
			int rowE = Integer.parseInt(st.nextToken());
			for(int j = row - rowS-1 ; j >= row-rowE ; j--){
				for(int k = colS ; k < colE ; k++){
					map[j][k] = 1;
				}
			}
		}
//		for(int[] i : map){
//			System.out.println(Arrays.toString(i));
//		}
		/////////////////////////////////////
		int result = 0;
		for(int i = 0 ; i< row ;i++){
			for(int j = 0 ; j < col ; j++){
				if(map[i][j]== 0){
					bfs(i, j);
					result++;
				}
			}
		}
		
		////////////////////////////////
		System.out.println(result);
		Collections.sort(list);
		for(Integer i : list){
			System.out.print(i+" ");
		}
	}

	private static void bfs(int i, int j) {
		int count = 1;
		int[] start = new int[]{i, j};
		map[i][j] = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()){
			int[] target = q.poll();
			for(int m = 0 ; m < 4 ; m++){
				int newX = target[0] + dir[m][0];
				int newY = target[1] + dir[m][1];
				if(newX >= 0 && newY >= 0 && newX < row && newY < col 
						&& map[newX][newY] == 0 ){
					map[newX][newY] = 1;
					count++;
					q.offer(new int[]{newX,newY});
				}
			}
		}
		list.add(count);
	}
	
}
