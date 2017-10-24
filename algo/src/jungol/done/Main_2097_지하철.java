package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_2097_¡ˆ«œ√∂ {

	static int cnt;
	static int destination;
	static int[][] map;
	static int[] distance;
	static boolean[] visited;
	static int[] route;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken()) - 1;
		map = new int[cnt][cnt];
		visited = new boolean[cnt];
		route = new int[cnt];
		distance = new int[cnt];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cnt; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		distance[0] = 0;
		/////////////////////////////////////

		int min = 0;
		int minPos = 0;
		int currentVertex = 0;
		while (currentVertex != destination) {
			min = Integer.MAX_VALUE;
			minPos = 0;
			for (int i = 0; i < cnt; i++) {
				if (!visited[i] && distance[i] < min) {
					min = distance[i];
					minPos = i;
				}
			}
			visited[minPos] = true;
			// update
			currentVertex = minPos;
			for (int i = 0; i < cnt; i++) {
				if (!visited[i] && map[currentVertex][i] != 0
						&& distance[i] > distance[currentVertex] + map[currentVertex][i]) {
					distance[i] = distance[currentVertex] + map[currentVertex][i];
					route[i] = currentVertex;
				}
			}
		}
		////////////////////////////////
		System.out.println(distance[destination]);
		ArrayList<Integer> list = new ArrayList<>();
		while(route[currentVertex] != 0){
			list.add(route[currentVertex]);
			currentVertex = route[currentVertex];
		}
		System.out.print(1 + " ");
		for(int i = list.size()-1 ; i >= 0 ; i--){
			System.out.print(list.get(i)+1 + " ");
		}
		System.out.print(destination+1);
	}

}
