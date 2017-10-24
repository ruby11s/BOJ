package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1871_줄세우기 {
	static int cnt;
	static int[] map;
	static int[] map2;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt+1];
		map2 = new int[cnt+1];
		for(int i = 1 ; i <= cnt ; i++){
			st = new StringTokenizer(br.readLine().trim());
			int temp = Integer.parseInt(st.nextToken());
			map[i] = temp;
			int tempMax = 0;
			for(int j = i-1 ; j >=0 ; j--){
				if(map[j] < temp && map2[j] > tempMax){
					tempMax = map2[j];
				}
			}
			map2[i] = tempMax+1;
			if(map2[i] > max){
				max = map2[i];
			}
		}
		System.out.println(cnt-max);
		
		
		////////////////////////////////////////////////////////////////////////////

	}// end main
}// end class
