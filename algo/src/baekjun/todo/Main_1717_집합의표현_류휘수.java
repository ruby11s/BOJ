package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1717_집합의표현_류휘수 {
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n+1];
		Arrays.fill(map, -1);
		
		int k = 0;
		int a = 0;
		int b = 0;
		
		for(int i = 0 ; i < m ; i++){
			st = new StringTokenizer(br.readLine().trim());
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(k == 0){
				//union
				union(a,b);
				
			} else {
				if(find(a) == find(b)){
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			
		}
		
		
		////////////////////////////////////////////
		
		
		////////////////////////////////////////////
 
	}// end main
 
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB){
			map[rootB] = rootA;
		}
	}

	// index 노드가 속한 루트 노드의 인덱스를 반환
	static int find(int index){
		if(map[index] == -1){
			return index;
		}
		return map[index] = find(map[index]);
	}
	
}// end class