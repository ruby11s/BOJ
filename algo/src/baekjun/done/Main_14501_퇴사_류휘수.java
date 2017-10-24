package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_Åð»ç_·ùÈÖ¼ö {
	static int N;
	static int[][] map;
	static int newX;
	static int newY;
	static boolean fin;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		////////////////////////////////////////////
		dfs(0, new boolean[N], 0);
		System.out.println(result);

		////////////////////////////////////////////

	}// end main

	static void dfs(int level, boolean sel[], int profit) {
		if (level == N) {
			if (profit > result) {
				result = profit;
			}
			return;
		}
		boolean sel2[] = new boolean[N];
		for(int i = 0 ; i < N ; i++){
			sel2[i] = sel[i];
		}
		dfs(level + 1, sel2, profit);
		if (level + map[level][0] <= N) {
			boolean isPossible = true;
			for (int i = level; i < level + map[level][0]; i++) {
				if (sel2[i]) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				for (int i = level; i < level + map[level][0]; i++) {
					sel2[i] = true;
				}
				dfs(level + 1, sel2, profit + map[level][1]);
			}
		}

	}

}// end class
