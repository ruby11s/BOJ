package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1937_øÂΩ…¿Ô¿Ã∆«¥Ÿ_∑˘»÷ºˆ {
	static int[][] map;
	static int n;
	static int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int max = Integer.MIN_VALUE;
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return map[o1[0]][o1[1]] - map[o2[0]][o2[1]];
		}
	});
	static int mapMax;
	static int[][] preMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		preMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > mapMax){
					mapMax = map[i][j];
				}
				pq.offer(new int[]{i, j});
			}
		}
		////////////////////////////////////////////
		while(!pq.isEmpty()){
			bfs(pq.poll());
		}
		System.out.println(max);
		
		////////////////////////////////////////////

	}// end main
	
	private static void bfs(int[] start) {
		if(preMap[start[0]][start[1]] > 1){
			return;
		} else {
			preMap[start[0]][start[1]] = 1;
		}
		if(mapMax - map[start[0]][start[1]] < max){
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		int[] newS = new int[]{start[0], start[1], 1};
		queue.offer(newS);
		int tempMax = 0;
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			if(cur[2] > tempMax){
				tempMax = cur[2];
			}
			int newX;
			int newY;
			for(int i = 0 ; i < 4 ; i++){
				newX = cur[0] + dir[i][0];
				newY = cur[1] + dir[i][1];
				if(newX>=0 && newY>= 0 && newX<n && newY < n
						&& map[newX][newY] > map[cur[0]][cur[1]]){
					if(preMap[newX][newY] < cur[2]){
						queue.offer(new int[]{newX, newY, cur[2]+1});
						preMap[newX][newY] = cur[2];
					}
				}
			}
		}
		if(tempMax > max){
			max = tempMax;
		}
		
	}

}// end class