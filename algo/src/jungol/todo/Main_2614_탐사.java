package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2614_Å½»ç {
	static int length;
	static int cnt;
	static int[][] map;
	static ArrayList<Integer> list;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		length = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt][3];

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			if (map[i][0] == map[i][1]) {
				if (map[i][2] == 0) {

				}
			}
		}
		////////////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////

	}// end main

}// end class
