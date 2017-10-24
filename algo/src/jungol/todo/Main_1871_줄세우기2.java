package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1871_줄세우기2 {
	static int cnt;
	static int[] map;
	static int[] map2;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt];
		map2 = new int[cnt];
		for(int i = 1 ; i <= cnt ; i++){
			st = new StringTokenizer(br.readLine().trim());
			int temp = Integer.parseInt(st.nextToken());
			map[i] = temp;
		}
		int size = 0;
		for(int i = 0 ; i < cnt; i++){
			int temp = Arrays.binarySearch(map2, 0, size, map[i]);
			temp = Math.abs(temp)-1;
			map2[temp] = map[i];
			
			if(temp == size){
				size++;
			}
		}
		
		System.out.println(cnt-size);
		
		
		////////////////////////////////////////////////////////////////////////////

	}// end main
}// end class
