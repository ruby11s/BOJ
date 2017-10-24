package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1205_Á¶Ä¿_·ùÈÖ¼ö {
	static int[] map;
	static int cnt;
	static int zeroCnt;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[cnt];
		st = new StringTokenizer(br.readLine().trim());
		for(int i = 0 ; i < cnt ; i++){
			map[i] = Integer.parseInt(st.nextToken()); 
			if(map[i] == 0) zeroCnt++;
		}
		////////////////////////////////////////////
		Arrays.sort(map);
		Stack<Integer> stack = new Stack<>();
		int temp = zeroCnt;
		for(int j = zeroCnt ; j < cnt ; j++){
			
			for(int i = j ; i < cnt ; i++){
				if(stack.isEmpty()){
					stack.push(map[i]);
				} else {
					if(stack.peek() + 1 == map[i]){
						stack.push(map[i]);
						continue;
					} else if ( stack.peek() == map[i]){
						continue;
					}
					else {
						if(temp != 0){
							stack.push(stack.peek()+1);
							temp--;
							i--;
							continue;
						} else {
							if(stack.size()>max){
								max = stack.size();
							}
						stack.clear();
						stack.push(map[i]);
						temp = zeroCnt;
						}
					}
				}
			}
		}
		if(stack.size() > max){
			max = stack.size();
		}
		if(temp != 0 && stack.size() + temp > max){
			max = stack.size()+ temp;
		}
		if(zeroCnt == cnt) System.out.println(cnt);
		else System.out.println(max);
		////////////////////////////////////////////

	}// end main

	
}// end class





