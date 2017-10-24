package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12100_2048_류휘수 {
	static int[][] map;
	static int cnt;
	static Stack<Integer> stack = new Stack<>();
	static int max = Integer.MIN_VALUE;
	static int initialMax = Integer.MIN_VALUE;
	static boolean notInitialMax = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt][cnt];
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cnt; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > initialMax) {
					initialMax = map[i][j];
				}
			}
		}
		////////////////////////////////////////////
		easy2048(0);
		////////////////////////////////////////////
		if(notInitialMax) System.out.println(max);
		else System.out.println(initialMax);

	}// end main

	static void easy2048(int level) {
		if (level == 5) {
			notInitialMax = true;
			int maxTemp = Integer.MIN_VALUE;
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < cnt; j++) {
					if (map[i][j] > maxTemp) {
						maxTemp = map[i][j];
					}
				}
			}
			if (maxTemp > max) {
				max = maxTemp;
			}
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			// 현재 맵 기억
			int[][] currentMap = new int[cnt][cnt];
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < cnt; j++) {
					currentMap[i][j] = map[i][j];
				}
			}
			for (int j = 0; j < cnt; j++) { // j번째 열에 대해
				boolean isMerged = false;
				for (int i = 0; i < cnt; i++) {
					if (map[i][j] != 0){
						if(!stack.isEmpty() && stack.peek() == map[i][j] && !isMerged){
							stack.push(stack.pop()+map[i][j]);
							isMerged = true;
						} else {
							stack.push(map[i][j]);
							isMerged = false;
						}
						map[i][j] = 0;
					}
				}
				int x = stack.size()-1;
				while (!stack.isEmpty()) {
					map[x--][j] = stack.pop();
				}
			}
			
			easy2048(level + 1);
			
			// 90도 돌리기
			for (int m = 0; m < cnt; m++) {
				for (int n = 0; n < cnt; n++) {
					map[cnt-1-n][m] = currentMap[m][n];
				}
			}
		}

	}

}// end class





