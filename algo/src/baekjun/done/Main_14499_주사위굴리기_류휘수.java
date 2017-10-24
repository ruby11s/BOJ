package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_ÁÖ»çÀ§±¼¸®±â_·ùÈÖ¼ö {
	static int[][] map;
	static int row;
	static int col;
	static int currentX;
	static int currentY;
	static int cnt;
	static Dice dice = new Dice();
	static int[][] dir = new int[][]{
		{0,0}, {0,1}, {0,-1}, {-1,0}, {1,0}
	};
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		currentX = Integer.parseInt(st.nextToken());
		currentY = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int input;
		for(int i = 0 ; i < cnt; i++){
			input = Integer.parseInt(st.nextToken());
			rollDice(input);
		}
		////////////////////////////////////////////
		////////////////////////////////////////////

	}// end main



	private static void rollDice(int input) {
		currentX = currentX + dir[input][0];
		currentY = currentY + dir[input][1];
		int temp1, temp2 = 0;
		if(currentX >= 0 && currentY >= 0 && currentX < row && currentY <col){
			if(input == 1){
				temp1 = dice.W;
				dice.W = dice.bottom;
				temp2 = dice.top;
				dice.top = temp1;
				temp1 = dice.E;
				dice.E = temp2;
				if(map[currentX][currentY] == 0){
					dice.bottom = temp1;
					map[currentX][currentY] = temp1;
				} else {
					dice.bottom = map[currentX][currentY];
					map[currentX][currentY] = 0;
				}
				System.out.println(dice.top);
				return;
			}
			if(input == 2){
				temp1 = dice.E;
				dice.E = dice.bottom;
				temp2 = dice.top;
				dice.top = temp1;
				temp1 = dice.W;
				dice.W = temp2;
				if(map[currentX][currentY] == 0){
					dice.bottom = temp1;
					map[currentX][currentY] = temp1;
				} else {
					dice.bottom = map[currentX][currentY];
					map[currentX][currentY] = 0;
				}
				System.out.println(dice.top);
				return;
			}
			if(input == 3){
				temp1 = dice.S;
				dice.S = dice.bottom;
				temp2 = dice.top;
				dice.top = temp1;
				temp1 = dice.N;
				dice.N = temp2;
				if(map[currentX][currentY] == 0){
					dice.bottom = temp1;
					map[currentX][currentY] = temp1;
				} else {
					dice.bottom = map[currentX][currentY];
					map[currentX][currentY] = 0;
				}
				System.out.println(dice.top);
				return;
			}
			if(input == 4){
				temp1 = dice.N;
				dice.N = dice.bottom;
				temp2 = dice.top;
				dice.top = temp1;
				temp1 = dice.S;
				dice.S = temp2;
				if(map[currentX][currentY] == 0){
					dice.bottom = temp1;
					map[currentX][currentY] = temp1;
				} else {
					dice.bottom = map[currentX][currentY];
					map[currentX][currentY] = 0;
				}
				System.out.println(dice.top);
				return;
			}
		} else {
			currentX = currentX - dir[input][0];
			currentY = currentY - dir[input][1];
			return;
		}
		
	}
	
	static class Dice{
		int top;
		int bottom;
		int E;
		int W;
		int N;
		int S;
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Dice [top=");
			builder.append(top);
			builder.append(", bottom=");
			builder.append(bottom);
			builder.append(", E=");
			builder.append(E);
			builder.append(", W=");
			builder.append(W);
			builder.append(", N=");
			builder.append(N);
			builder.append(", S=");
			builder.append(S);
			builder.append("]");
			return builder.toString();
		}
		
	}

}// end class





