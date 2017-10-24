package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기 {
	static int cnt;
	static int cntColored;
	static int cntWhite;
	static int[][] map;
	static int[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		cnt = Integer.parseInt(br.readLine().trim());
		map = new int[cnt][cnt];

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < cnt; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// for(int[] i : map){
		// System.out.println(Arrays.toString(i));
		// }

		paperCut(0, 0, cnt);
		System.out.println(cntWhite);
		System.out.println(cntColored);

	}// end main

	private static void paperCut(int x, int y, int size) {
		int coloredNum = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == 1) {
					coloredNum++;
				}
			}
		}
		if (coloredNum == size*size) {
			cntColored++;
			return;
		} else if( coloredNum == 0){ 
			cntWhite++;
			return;
		}
		else {
			int halfSize = size / 2;
			paperCut(x, y, halfSize);
			paperCut(x + halfSize, y, halfSize);
			paperCut(x, y + halfSize, halfSize);
			paperCut(x + halfSize, y + halfSize, halfSize);
		}
	}

}// end class