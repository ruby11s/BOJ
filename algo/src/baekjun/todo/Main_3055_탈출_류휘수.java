package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_Å»Ãâ_·ùÈÖ¼ö {
	static int row;
	static int col;
	static char[][] map;
	static int[] D;
	static int[] S;
	static int[][] dir = new int[][]{
		{0, 1}, {0, -1}, {1, 0}, {-1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		
		Queue<int[]> q = new LinkedList<>();
		char temp;
		for(int i = 0 ; i < row ; i++){
			String str= br.readLine().trim();
			for(int j = 0 ; j < col ; j++){
				temp = str.charAt(j);
				if(temp == 'D'){
					D = new int[]{i, j};
				} else if(temp == 'S'){
					S = new int[]{i, j, 0};
				}
				
				map[i][j] = temp;
			}
		}
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ;j++){
				if(map[i][j] == '*'){
					q.offer(new int[]{i, j});
				}
			}
		}
		q.offer(S);
		boolean fin = false;
		O : while(!q.isEmpty()){
			int[] cur = q.poll();
			int newX;
			int newY;
			for(int i = 0 ; i < 4 ; i++){
				newX = cur[0] + dir[i][0];
				newY = cur[1] + dir[i][1];
				if( newX >= 0 && newY >= 0 && newX < row && newY < col && map[newX][newY] != 'X'){
					if(cur.length == 2){ // ¹°ÀÌ¶ó¸é
						if( map[newX][newY] != 'D' && map[newX][newY] != '*'){
							map[newX][newY] = '*';
							q.offer(new int[]{newX,newY});
						}
					} else if (cur.length==3){
						if( map[newX][newY] != '*' && map[newX][newY] != 'S'){
							if(map[newX][newY] == 'D'){
								System.out.println(cur[2]+1);
								fin = true;
								break O;
							}
							map[newX][newY] = 'S';
							q.offer(new int[]{newX, newY, cur[2]+1});
						}
					}
				}
			}
			
		}
		if(!fin){
		System.out.println("KAKTUS");
		}
		
	}// end main
	

}// end class