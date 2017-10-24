package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1408_¿¸±Í¡Ÿ_√  {
	static int cnt;
	static int[][] map;
	static int[] map2;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[2][cnt + 1];
		map2 = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int temp = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			map[0][i] = temp;
			map[1][i] = temp2;

		}

		for (int i = 0; i < cnt; i++) {
			for (int j = 1; j < cnt - i; j++) {
				if (map[0][j] > map[0][j + 1]) {
					int temp;
					temp = map[0][j];
					map[0][j] = map[0][j + 1];
					map[0][j + 1] = temp;
					temp = map[1][j];
					map[1][j] = map[1][j + 1];
					map[1][j + 1] = temp;
				}
			}
		}
		for (int i = 1; i <= cnt; i++) {
			int tempMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (map[0][j] < map[0][i] && map[1][j] < map[1][i] && map2[j] > tempMax) {
					tempMax = map2[j];
				}
			}
			map2[i] = tempMax + 1;
			if (map2[i] > max) {
				max = map2[i];
			}
		}
		System.out.println(cnt - max);

		////////////////////////////////////////////////////////////////////////////

	}// end main
}// end class
