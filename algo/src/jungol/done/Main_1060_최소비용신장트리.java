package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1060_최소비용신장트리 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] input = new int[n][n];
		StringTokenizer st = null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[n];
		ArrayList<Integer> list = new ArrayList<>();
		int result = 0, min, minIndex = 0;

		visited[0] = true;
		list.add(0);
		while (true) {
			min = Integer.MAX_VALUE;
			minIndex = -1;
			for (Integer i : list) {
				for (int j = 0; j < n; j++) {
					if (!visited[j] && input[i][j] != 0 && input[i][j] < min) {
						min = input[i][j];
						minIndex = j;
					}
				}
			}
			result += min;
			visited[minIndex] = true;
			list.add(minIndex);
			if(list.size() == n) break;
		}
		
		System.out.println(result);

	}

}
