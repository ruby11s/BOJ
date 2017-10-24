package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main_1108_페이지전환 {

	static int cnt;
	static int[][] distance;
	static boolean[] visited;
	static int[] route;
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		cnt = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < cnt ; i++){
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			if(!map.containsKey(temp)){
				ArrayList<Integer> list = new ArrayList<>();
				map.put(temp, list);
			} 
			map.get(temp).add(temp2);
			if(temp > max) max = temp;
			if(temp2 > max) max = temp2;
		}
		/////////////////////////////////////
		distance = new int[max+1][max+1];
		for(int[] i : distance){
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		visited = new boolean[max+1];
		
		int min = 0;
		int minPos = 0;
		for(int i = 1 ; i <= max ; i++){
			int currentVertex = i;
			Arrays.fill(visited, false);
			int trueCnt = 0;
			while (true) {
				trueCnt++;
				distance[i][i] = 0;
				min = Integer.MAX_VALUE;
				for (int j = 1; j <= max; j++) {
					if (!visited[j] && distance[i][j] < min) {
						min = distance[i][j];
						minPos = j;
					}
				}
				visited[minPos] = true;
				// update
				currentVertex = minPos;
				for (int j = 1; j <= max; j++) {
					if (!visited[j] && map.get(currentVertex).contains(j)
							&& distance[i][j] > distance[i][currentVertex] + 1) {
						distance[i][j] = distance[i][currentVertex] + 1;
					}
				}
				if(trueCnt == max) break;
			}
			
			
		}
		////////////////////////////////
		int result = 0;
		for(int i = 1 ; i<=max ; i++){
			for(int j = 1 ; j<=max ; j++){
				if(i!=j){
					result += distance[i][j];
				}
			}
		}
		double resultT = (double)result/((max*max)-max);
		System.out.printf("%.3f",resultT);
	}

}
