package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1408_Àü±êÁÙ_Áß_·ùÈÖ¼ö {
	static int cnt;
	static int[][] map;
	static int[] map2;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt+1][2];
		for (int i = 1; i <= cnt; i++) {
			st = new StringTokenizer(br.readLine().trim());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		int[] binaryLocIndex= new int[cnt+1];
		int[] parent = new int[cnt+1];
		int[] forBinary = new int[cnt];
		Arrays.fill(forBinary, Integer.MAX_VALUE);
		int size = 0;
		int loc;
		for(int i = 1 ; i <= cnt ; i++){
			int target = map[i][1];
			loc = Arrays.binarySearch(forBinary, 0, size, target);
			loc = Math.abs(loc)-1;
			if(forBinary[loc] == Integer.MAX_VALUE){
				size++;
			} 
			parent[i] = binaryLocIndex[loc];
			binaryLocIndex[loc] = i;
			forBinary[loc] = target;
		}

		System.out.println(cnt-size);
		int preIndex;
		int curIndex = binaryLocIndex[size-1];
		for(int i = size-2 ; i >=0 ; i--){
			preIndex = binaryLocIndex[i];
			while(!(preIndex < curIndex && map[preIndex][1] < map[curIndex][1])){
				preIndex = parent[preIndex];
			}
			forBinary[i] = map[preIndex][1];
			curIndex = preIndex;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= cnt ; i++){
			if(Arrays.binarySearch(forBinary, 0, size, map[i][1])>=0){
				continue;
			} else {
				sb.append(map[i][0]).append("\n");
			}
		}
		System.out.println(sb);
		////////////////////////////////////////////////////////////////////////////

	}// end main
}// end class
