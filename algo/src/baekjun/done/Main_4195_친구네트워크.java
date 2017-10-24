package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main_4195_친구네트워크 {
	static int cnt;
	static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		cnt = Integer.parseInt(st.nextToken());
		String f1;
		String f2;
		for(int i = 0 ; i < cnt ; i++){
			st = new StringTokenizer(br.readLine().trim());
			int f = Integer.parseInt(st.nextToken());
			map.clear();
			for(int j = 0 ; j < f ; j++){
				st = new StringTokenizer(br.readLine().trim());
				f1 = st.nextToken();
				f2 = st.nextToken();
				if(!map.containsKey(f1) && !map.containsKey(f2)){
					map.put(f1, "#2");
					map.put(f2, f1);
					System.out.println(2);
					continue;
				} else if(map.containsKey(f1) && !map.containsKey(f2)){
					String root = find(f1);
					map.put(f2, root);
					map.put(root, "#"+(Integer.parseInt(map.get(root).substring(1))+1));
					System.out.println(map.get(root).substring(1));
				} else if(!map.containsKey(f1) && map.containsKey(f2)){
					String root = find(f2);
					map.put(f1, root);
					map.put(root, "#"+(Integer.parseInt(map.get(root).substring(1))+1));
					System.out.println(map.get(root).substring(1));
				} else {
					String root1 = find(f1);
					String root2 = find(f2);
					if(root1.equals(root2)){
						System.out.println(map.get(root1).substring(1));
					} else {
						int root2Int = Integer.parseInt(map.get(root2).substring(1));
						map.put(root2, root1);
						map.put(root1, "#"+(Integer.parseInt(map.get(root1).substring(1))+root2Int));
						System.out.println(map.get(root1).substring(1));
					}
				}
				
			}
		}
		
		
		////////////////////////////////////////////
		
		
		////////////////////////////////////////////
 
	}// end main
 
	// index 노드가 속한 루트 노드의 인덱스를 반환
	static String find(String index){
		if(map.get(index).charAt(0) == '#'){
			return index;
		}
		
		return find(map.get(index));
	}
	
}// end class