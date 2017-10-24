package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1409_벽장문의이동 {

	static int cnt;
	static int open1;
	static int open2;
	static int[] order;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		open1 = Integer.parseInt(st.nextToken());
		open2 = Integer.parseInt(st.nextToken());
		if(open1> open2){
			int temp = open1;
			open1 = open2;
			open2 = temp;
		}
		st = new StringTokenizer(br.readLine());
		order = new int[Integer.parseInt(st.nextToken())+1];
		for(int i = 1 ; i < order.length ; i++){
			st = new StringTokenizer(br.readLine());
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		dfs(1, 0);
		System.out.println(min);
		
		
	}
	
	static void dfs(int level, int count){
		if(level == order.length){
			if(count < min){
				min = count;
			}
			return;
		}
		int value = order[level];
		int temp;
		if(value == open1 || value == open2){
			dfs(level+1, count);
			return;
		}
		if(value < open1){
			temp = open1;
			open1 = value;
			dfs(level+1, count + (temp-value));
			open1 = temp;
			return;
		}
		if(open2 < value){
			temp = open2;
			open2 = value;
			dfs(level+1, count + (value-temp));
			open2 = temp;
			return;
		}
		if(open1<value && value <open2){
			temp = open1;
			open1 = value;
			dfs(level+1, count + (value-temp));
			open1 = temp;
			temp = open2;
			open2 = value;
			dfs(level+1, count + (temp-value));
			open2 = temp;
			return;
		}
	}

}
