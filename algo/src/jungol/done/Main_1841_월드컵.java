package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1841_¿ùµåÄÅ {
	static int max = Integer.MIN_VALUE;
	static int[] map = new int[18];
	static boolean isFin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	OUTER:	for (int i = 0; i < 4; i++) {
			isFin = false;
			st = new StringTokenizer(br.readLine().trim());
			int sum = 0;
			for(int j = 0 ; j < 6 ; j++){
				sum = 0;
				for (int k = j*3; k <j*3+3; k++) {
					map[k] = Integer.parseInt(st.nextToken());
					sum += map[k];
				}
				if(sum > 5) {
					System.out.print(0+ " ");
					continue OUTER;
				}
			}
			dfs(1);
			if(isFin == false) System.out.print(0+" ");
		}

	}// end main

	static void dfs(int level) {
		if(isFin == true) return;
		if(level == 16) {
			System.out.print(1+" ");
			isFin = true;
			return;
		}
		if (1 <= level && level < 6) { // 1¹ø ÆÀ 1 2 3 4 5

			if (map[0] > 0) {
				map[0]--;
				map[level * 3 + 2]--;
				if (map[(level) * 3 + 2] >= 0) {
					dfs(level + 1);
				}
				map[0]++;
				map[(level) * 3 + 2]++;
			} 
			if (map[1] > 0) {
				map[1]--;
				map[(level) * 3 + 1]--;
				if (map[(level) * 3 + 1] >= 0) {
					dfs(level + 1);
				}
				map[1]++;
				map[(level) * 3 + 1]++;
			}
			if (map[2] > 0) {
				map[2]--;
				map[(level) * 3]--;
				if (map[(level) * 3] >= 0) {
					dfs(level + 1);
				}
				map[2]++;
				map[(level) * 3]++;
			}
		} else if (6 <= level && level < 10) { // 2¹ø ÆÀ 6 7 8 9

			if (map[3] > 0) {
				map[3]--;
				map[(level - 4) * 3 + 2]--;
				if (map[(level - 4) * 3 + 2] >= 0) {
					dfs(level + 1);
				}
				map[3]++;
				map[(level - 4) * 3 + 2]++;
			}
			if (map[4] > 0) {
				map[4]--;
				map[(level - 4) * 3 + 1]--;
				if (map[(level - 4) * 3 + 1] >= 0) {
					dfs(level + 1);
				}
				map[4]++;
				map[(level - 4) * 3 + 1]++;
			}
			if (map[5] > 0) {
				map[5]--;
				map[(level - 4) * 3]--;
				if (map[(level - 4) * 3] >= 0) {
					dfs(level + 1);
				}
				map[5]++;
				map[(level - 4) * 3]++;
			}
		} else if (10 <= level && level < 13) { // 3¹ø ÆÀ 10 11 12

			if (map[6] > 0) {
				map[6]--;
				map[(level - 7) * 3 + 2]--;
				if (map[(level - 7) * 3 + 2] >= 0) {
					dfs(level + 1);
				}
				map[6]++;
				map[(level - 7) * 3 + 2]++;
			}
			if (map[7] > 0) {
				map[7]--;
				map[(level - 7) * 3 + 1]--;
				if (map[(level - 7) * 3 + 1] >= 0) {
					dfs(level + 1);
				}
				map[7]++;
				map[(level - 7) * 3 + 1]++;
			}
			if (map[8] > 0) {
				map[8]--;
				map[(level - 7) * 3]--;
				if (map[(level - 7) * 3] >= 0) {
					dfs(level + 1);
				}
				map[8]++;
				map[(level - 7) * 3]++;
			}
		} else if (13 <= level && level < 15) { // 4¹ø ÆÀ 13 14

			if (map[9] > 0) {
				map[9]--;
				map[(level - 9) * 3 + 2]--;
				if (map[(level - 9) * 3 + 2] >= 0) {
					dfs(level + 1);
				}
				map[9]++;
				map[(level - 9) * 3 + 2]++;
			}
			if (map[10] > 0) {
				map[10]--;
				map[(level - 9) * 3 + 1]--;
				if (map[(level - 9) * 3 + 1] >= 0) {
					dfs(level + 1);
				}
				map[10]++;
				map[(level - 9) * 3 + 1]++;
			} 
			if (map[11] > 0) {
				map[11]--;
				map[(level - 9) * 3]--;
				if (map[(level - 9) * 3] >= 0) {
					dfs(level + 1);
				}
				map[11]++;
				map[(level - 9) * 3]++;
			}
		} else if (level == 15) { // 5¹ø ÆÀ

			if (map[12] != 0) {
				map[12]--;
				map[17]--;
				if (map[17] >= 0) {
					dfs(level + 1);
				}
				map[12]++;
				map[17]++;
			}
			if (map[13] > 0) {
				map[13]--;
				map[16]--;
				if (map[16] >= 0) {
					dfs(level + 1);
				}
				map[13]++;
				map[16]++;
			} 
			if (map[14] > 0) {
				map[14]--;
				map[15]--;
				if (map[15] >= 0) {
					dfs(level + 1);
				}
				map[14]++;
				map[15]++;
			}
		}

	}
}// end class
