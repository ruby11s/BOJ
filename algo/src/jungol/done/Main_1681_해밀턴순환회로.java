package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1681_해밀턴순환회로 {

	static int cnt;
	static boolean[] visited;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt][cnt];
		visited = new boolean[cnt];
		for(int i = 0 ; i < cnt ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < cnt ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/////////////////////////////////////
		visited[0] = true;
		dfs(0, 0, 0);
		System.out.println(min);
		
		////////////////////////////////
	}
	
	static void dfs(int level, int cost, int vertex){
		if(cost>min) return;
		if(level == cnt-1){
			if(map[vertex][0] == 0){
				return;
			} else {
				cost += map[vertex][0];
			}
			if(cost < min){
				min = cost;
			}
			return;
		}
		for(int i = 0 ; i < cnt ; i++){
			if(!visited[i] && map[vertex][i] != 0){
				visited[i] = true;
				cost += map[vertex][i];
				dfs(level+1, cost, i);
				cost -= map[vertex][i];
				visited[i] = false;
			}
		}
	}

}
