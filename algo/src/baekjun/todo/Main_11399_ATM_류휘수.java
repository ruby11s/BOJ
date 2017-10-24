package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM_·ùÈÖ¼ö {
	static int cnt;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt];
		st = new StringTokenizer(br.readLine().trim());
		for(int i = 0 ; i < cnt ; i++){
			map[i] = Integer.parseInt(st.nextToken());
		}
		long result = 0;
		long reresult = 0;
		Arrays.sort(map);
		long pre = 0;
		for(int i = 0 ; i < cnt ; i++){
			result = pre + map[i];
			pre = result;
			reresult += result;
		}
		System.out.println(reresult);
		
	}// end main
	

}// end class