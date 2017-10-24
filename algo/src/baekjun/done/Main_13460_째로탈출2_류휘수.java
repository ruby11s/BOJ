package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_Â°·ÎÅ»Ãâ2_·ùÈÖ¼ö {
	static char[][] map;
	static int row;
	static int col;
	static int[] goal = new int[2];
	static int[] curR = new int[2];
	static int[] curB = new int[2];
	static int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		char temp;
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				temp = str.charAt(j);
				if (temp == 'B') {
					curB[0] = i;
					curB[1] = j;
					map[i][j] = '.';
				} else if (temp == 'R') {
					curR[0] = i;
					curR[1] = j;
					map[i][j] ='.';
				} else if (temp == 'O') {
					goal[0] = i;
					goal[1] = j;
					map[i][j] = temp;
				} else {
					map[i][j] = temp;
				}
			}
		}
		////////////////////////////////////////////
		zzae(0, curR, curB);
		if(result!=Integer.MAX_VALUE) System.out.println(result);
		else System.out.println(-1);
		////////////////////////////////////////////

	}// end main

	private static void zzae(int level, int[] curRed, int[] curBlue) {
		if(level == 10) {
			return;
		}
		boolean isFin = false;
		boolean isViolated = false;
		int[] initRed = new int[]{curRed[0], curRed[1]};
		int[] initBlue = new int[]{curBlue[0], curBlue[1]};
		for (int i = 0; i < 4; i++) {
			isFin = false;
			isViolated = false;
			curRed[0] = initRed[0];
			curRed[1] = initRed[1];
			curBlue[0] = initBlue[0];
			curBlue[1] = initBlue[1];
			int[] newRed = new int[] { curRed[0], curRed[1] };
			int[] newBlue = new int[] { curBlue[0], curBlue[1] };
			boolean isRedDone = false;
			while (true) {// »¡°£±¸½½ ±¼¸®ÀÚ
				newRed[0] = curRed[0] + dir[i][0];
				newRed[1] = curRed[1] + dir[i][1];
				if (newRed[0] == goal[0] && newRed[1] == goal[1]) {
					isFin = true;
					isRedDone = true;
					curRed[0] = newRed[0];
					curRed[1] = newRed[1];
					break;
				} else if (map[newRed[0]][newRed[1]] == '#') {
					isRedDone = true;
					break;
				} else if (newRed[0] == curBlue[0] && newRed[1] == curBlue[1]) {
					isRedDone = false;
					break;
				} else {
					curRed[0] = newRed[0];
					curRed[1] = newRed[1];
				}
			}
			while (true) {// ÆÄ¶õ±¸½½ ±¼¸®ÀÚ
				newBlue[0] = curBlue[0] + dir[i][0];
				newBlue[1] = curBlue[1] + dir[i][1];
				if (newBlue[0] == goal[0] && newBlue[1] == goal[1]) {
					isFin = false;
					isViolated = true;
					break;
				} else if (map[newBlue[0]][newBlue[1]] == '#') {
					break;
				} else if (newBlue[0] == curRed[0] && newBlue[1] == curRed[1]) {
					break;
				} else {
					curBlue[0] = newBlue[0];
					curBlue[1] = newBlue[1];
				}
			}
			if(!isRedDone){
				while (true) {// »¡°£±¸½½ ±¼¸®ÀÚ
					newRed[0] = curRed[0] + dir[i][0];
					newRed[1] = curRed[1] + dir[i][1];
					if (newRed[0] == curBlue[0] && newRed[1] == curBlue[1]) {
						break;
					} else {
						curRed[0] = newRed[0];
						curRed[1] = newRed[1];
					}
				}
			}
			
			
			if(isFin) {
				if(level + 1 < result){
					result = level+1;
				}
				isFin = false;
				continue;
			}
			if(isViolated){
				isViolated = false;
				continue;
			}
			zzae(level+1, curRed, curBlue);
			
		}

	}

}// end class
