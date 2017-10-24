package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1127_PERKET_·ùÈÖ¼ö {
	static int[][] map;
	static int cnt;
	static int min = Integer.MAX_VALUE;
	static int[] onlyOne;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt][2];
		onlyOne = new int[cnt];
		for(int i = 0 ; i < cnt ; i++){
			st = new StringTokenizer(br.readLine().trim());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			onlyOne[i] = Math.abs(map[i][0] - map[i][1]);
		}
		////////////////////////////////////////////
		perket(0, 1, 0, 0);
		System.out.println(min);
		
		////////////////////////////////////////////

	}// end main

	static void perket(int level, int S, int B, int count){
		if( level == cnt){
			if(count == 0) return;
			if(Math.abs(S-B) < min){
				min = Math.abs(S-B);
			}
			return;
		}
		
		int newS = S*map[level][0];
		int newB = B+map[level][1];
		
		perket(level+1, S, B, count);
		perket(level+1, newS, newB, count+1);
	}
	
}// end class





