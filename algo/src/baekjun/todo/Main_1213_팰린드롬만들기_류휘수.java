package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_1213_ÆÓ¸°µå·Ò¸¸µé±â_·ùÈÖ¼ö {
	static String target;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine().trim();
		int length = target.length();
		HashMap<Character, Integer> map = new HashMap<>();
		char temp1;
		for(int i = 0 ; i < length ; i++){
			temp1 = target.charAt(i);
			if(map.containsKey(temp1)){
				map.put(temp1, map.get(temp1)+1);
			} else {
				map.put(temp1, 1);
			}
		}
		
		boolean flag = true;
		if(length % 2 == 0){
			for(Integer i : map.values()){
				if(i%2 != 0){
					flag = false;
					break;
				}
			}
		} else {
			int cnt = 0;
			for(Integer i : map.values()){
				if(i%2 == 1){
					cnt++;
				}
			}
			if(cnt != 1){
				flag = false;
			}
		}
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		if(flag){
			if(length % 2 == 0){
				for(char temp2 : map.keySet()){
					int temp3 = map.get(temp2);
					for(int i = 0 ; i < temp3/2 ; i++){
						sb.append(temp2);
					}
				}
				char[] temp4 = sb.toString().toCharArray();
				Arrays.sort(temp4);
				result.append(temp4);
				sb.setLength(0);
				sb.append(temp4);
				sb.reverse();
				result.append(sb);
				System.out.println(result);
			} else {
				char middle = 0;
				for(char temp2 : map.keySet()){
					int temp3 = map.get(temp2);
					if(temp3 % 2 == 1) middle = temp2;
					for(int i = 0 ; i < temp3/2 ; i++){
						sb.append(temp2);
					}
				}
				char[] temp4 = sb.toString().toCharArray();
				Arrays.sort(temp4);
				result.append(temp4);
				sb.setLength(0);
				sb.append(temp4);
				sb.reverse();
				result.append(middle);
				result.append(sb);
				System.out.println(result);
			}
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
		
		
		
		
		
	}// end main
	

}// end class