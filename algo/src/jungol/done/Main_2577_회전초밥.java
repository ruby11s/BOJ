package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main_2577_»∏¿¸√ π‰ {
	static int n;
	static int d;
	static int k;
	static int c;
	static int[] map;
	static int max = Integer.MIN_VALUE;
	static HashMap<Integer, Integer> tree = new HashMap<>();
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[n];
        for(int i = 0 ; i < n ; i++){
        	st = new StringTokenizer(br.readLine().trim());
        	map[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0 ; i < k ; i++){
        	if(tree.containsKey(map[i])){
        		tree.put(map[i], tree.get(map[i])+1);
        	} else {
        		tree.put(map[i], 1);
        	}
        }
        max = tree.size();
        if(!tree.containsKey(c)) max++; 
        
        int temp = 0;
        int target = 0;
        int tempI = 0;
        for(int i = k ; i < n+k-1 ; i++){
        	if(i >= n) tempI = i%n;
        	else tempI = i;
        	target = map[tempI];
        	if(tree.containsKey(target)){
        		tree.put(target, tree.get(target)+1);
        	} else {
        		tree.put(target, 1);
        	}
        	tree.put(map[i-k], tree.get(map[i-k]).intValue()-1);
        	if(tree.get(map[i-k]) == 0) tree.remove(map[i-k]);
        	temp = tree.size();
        	if(!tree.containsKey(c)) temp++;
        	if(temp>max) max = temp;
        }
        
        System.out.println(max);
        
    }// end main
 
}// end class
