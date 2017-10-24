package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int n;
	static int m;
	static int[] map = new int[n + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if (n == 1) {
			System.out.println(1);
			return;
		} else if (m == 0) {
			System.out.println(n);
			return;
		}
		int a, b;
		map = new int[n + 1];
		Arrays.fill(map, -1); // 모든 학생이 각각의 종교를 가지고 있다.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int result = 0;
		for(int i = 1 ; i <=n ; i++){
			if(map[i] == -1) result++; 
		}
		System.out.println(result);
		////////////////////////////////////////////////////////////////////////////
		

	}// end main
	static void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB){
			map[rootB] = rootA;
		}
	}
	
	static int find(int a){
		if(map[a] == -1){
			return a;
		}
		return map[a] = find(map[a]);
	}
}// end class
