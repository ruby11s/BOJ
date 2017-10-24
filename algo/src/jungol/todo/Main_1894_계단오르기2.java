package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1894_계단오르기2 {
	static int cnt;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt + 1];
		if (cnt == 1) {
			System.out.println(1);
		} else {
			map[0] = 1;
			map[1] = 1;
			System.out.println(dp(cnt));
		}

		////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////

	}// end main

	static int dp(int index) {
		int result1 = 0;
		int result2 = 0;

		if (map[index - 1] == 0) {
			result1 = dp(index - 1);
		} else {
			result1 = map[index - 1];
		}

		if (map[index - 2] == 0) {
			result2 = dp(index - 2);
		} else {
			result2 = map[index - 2];
		}

		map[index] = result1+result2;
		return result1 + result2;

	}

}// end class
