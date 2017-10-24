package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_·Îº¿Ã»¼Ò±â_·ùÈÖ¼ö {
	static int N;
	static int M;
	static int r;
	static int c;
	static int d;
	static int[][] map;
	static int[][] dir = new int[][] { { -1, 0 }, // ºÏ
			{ 0, 1 }, // µ¿
			{ 1, 0 }, // ³²
			{ 0, -1 } // ¼­
	};
	static int result;
	static int curDir;
	static int[] curPos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////
		curDir = d;
		curPos = new int[2];
		curPos[0] = r;
		curPos[1] = c;
		int newR;
		int newC;
		O: while (true) {
			// Ã»¼Ò
			if (map[curPos[0]][curPos[1]] == 0) {
				map[curPos[0]][curPos[1]] = 2;
				result++;
			}

			for (int i = 0; i < 4; i++) {
				int nextDir = turn(curDir);
				newR = curPos[0] + dir[nextDir][0];
				newC = curPos[1] + dir[nextDir][1];
				if (map[newR][newC] == 0) {
					curDir = nextDir;
					curPos[0] = newR;
					curPos[1] = newC;
					continue O;
				} else {
					curDir = nextDir;
				}
			}
			newR = curPos[0] - dir[curDir][0];
			newC = curPos[1] - dir[curDir][1];
			if (map[newR][newC] == 1) {
				break;
			} else {
				curPos[0] = newR;
				curPos[1] = newC;
			}

		}

		////////////////////////////////////////////

		System.out.println(result);
	}// end main

	static int turn(int direction) {
		switch (direction) {
		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		default:
			return 5;
		}
	}

}// end class
