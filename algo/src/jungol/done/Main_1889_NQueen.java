package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1889_NQueen {
	static int size;
	static boolean[] col;
	static boolean[] slash;
	static boolean[] bSlash;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine().trim());
		/////////////////////////////////////////////////////////////////////////
		col = new boolean[size];
		slash = new boolean[2*size-1];
		bSlash = new boolean[2*size-1];
		//////////////////////////////////////////////////////////////////////////
		dfs(0);
		System.out.println(cnt);
	}
	
	static void dfs(int row){
		if(row >= size) {
			cnt++;
			return;
		}
		for(int i = 0 ; i < size ; i++){
			if(col[i] == false && slash[row+i] == false && bSlash[size-1-row+i] == false){ // can be put
				col[i] = true;
				slash[row+i] = true;
				bSlash[size-1-row+i] = true;
				dfs(row+1);
				col[i] = false;
				slash[row+i] = false;
				bSlash[size-1-row+i] = false;
			}
		}
	}
}
