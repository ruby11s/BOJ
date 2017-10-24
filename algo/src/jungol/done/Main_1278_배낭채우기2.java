package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1278_¹è³¶Ã¤¿ì±â2 {
	static int n;
	static int w;
	static int[][] wp;
	static int[] result;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		wp = new int[n][2];
		result = new int[w+1];
		check = new boolean[w+1][n];
		
		for(int i = 0 ; i < n ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 2 ; j++){
				wp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(wp, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = wp[0][0] ; i <= w ; i ++){
			list.clear();
			for(int j = 0; j < n ; j++){
				if(i-wp[j][0] >= 0) list.add(result[i-wp[j][0]] + wp[j][1]);
			}
			result[i] = Collections.max(list);
		}
		System.out.println(Arrays.toString(result));
		System.out.println(result[w]);
		
	}
}
