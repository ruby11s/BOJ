package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2101_연속부분최대곱_류휘수 {
	static int cnt;
	static double[] map;
	static double result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		map = new double[cnt];
		for(int i = 0 ; i < cnt ; i++){
			st = new StringTokenizer(br.readLine().trim());
			map[i] = Double.parseDouble(st.nextToken());
			
		}
		
		/////////////////////////////////////////////
		dp(cnt-1);
		System.out.printf("%.3f",result);
		/////////////////////////////////////////////
		
	}// main
	
	static double dp(int level){
		if(level == 0) return map[0];
		double value = dp(level-1)*map[level];
		if(value > map[level]) {
			if(value > result){
				result = value;
			}
			return value;
		}
		else {
			if(map[level] > result){
				result = map[level];
			}
			return map[level];
		}
	}
	
}// class
