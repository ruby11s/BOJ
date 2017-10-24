package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1027_좋은수열 {
	static int size;
	static int[] arr;
	static int[] result;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Integer> list;
	static StringBuilder sb = new StringBuilder();
	static boolean end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine().trim());
/////////////////////////////////////////////////////////////////////////
		dfs(1);
		
//////////////////////////////////////////////////////////////////////////
	}

	private static void dfs(int level) {
		if(level == size+1){
			System.out.println(sb.toString());
			end = true;
			return;
		}
		for(int i = 1 ; i <= 3 ; i++){
			sb.append(String.valueOf(i));
			boolean bl = true;
			int length = sb.length();
			for(int j = 1 ; j <= length/2 ;j++){
				String first = sb.subSequence(length-j-j, length-j).toString();
				String second = sb.subSequence(length-j, length).toString();
				if(first.equals(second)){
					bl = false;
					break;
				}
			}
			if(bl){
				dfs(level+1);
				if(end) return;
			}
			sb = sb.deleteCharAt(length-1);
		}
	}
	
}
