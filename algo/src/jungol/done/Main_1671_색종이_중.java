package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1671_색종이_중 {
	static int cnt;
	static int[][] map = new int[100][100];
	static int[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		cnt = Integer.parseInt(br.readLine().trim());
		paper = new int[cnt][2];
		
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int col = Integer.parseInt(st.nextToken());
			paper[i][0] = col;
			int row = Integer.parseInt(st.nextToken());
			paper[i][1] = row;
			for (int j = row; j < row + 10; j++) {
				for (int k = col; k < col + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i = 0; i < cnt ; i++){
			int col = paper[i][0];
			int row = paper[i][1];
			for(int j = row+1 ; j < row+9 ; j++){
				for(int k = col +1 ; k < col+9 ; k++){
					map[j][k] = 0;
				}
			}
		}
		
		for(int[] i : map){
			System.out.println(Arrays.toString(i));
		}
		
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 99; j++) {
				if(map[i][j] != map[i][j+1]) result++;
			}
		}
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 99; i++) {
				if(map[i][j] != map[i+1][j]) result++;
			}
		}
		for(int i = 0 ; i < 100 ; i++){
			if(map[i][0] == 1) result++;
			if(map[0][i] == 1) result++;
			if(map[i][99] == 1) result++;
			if(map[99][i] == 1) result++;
		}
		System.out.println(result);

	}// end main

}// end class