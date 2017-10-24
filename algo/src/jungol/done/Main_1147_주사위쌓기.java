package jungol.done;

import java.util.Scanner;

public class Main_1147_ÁÖ»çÀ§½×±â {
	static int cnt;
	static int[][] dice;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		cnt = s.nextInt();
		dice = new int[cnt][6];
		for(int i = 0 ; i < cnt ; i++){
			for(int j = 0 ; j < 6 ; j ++){
				dice[i][j] = s.nextInt();
			}
		}
		s.close();
///////////////////////////////////////////////////////////
		int max = dice(1, 0);
		for(int i = 1 ; i < 6 ; i++){
			int temp = dice(1, i);
			if(temp > max) max = temp;
		}
		System.out.println(max);
		
	}
	
	static int dice(int level, int bot){
		
		int max = -1;
		int top = botToTop(bot);
		for(int i = 0 ; i < 6 ; i++){
			if(!(i == bot || i == top)){
				if(dice[level-1][i] > max){
					max = dice[level-1][i];
				}
			}
		}
		if(level == cnt) return max;
		return max + dice(level+1, indexOfBot(level-1, top));
	}
	
	static int botToTop(int num){
		switch(num){
		case 0: return 5;
		case 1: return 3;
		case 2: return 4;
		case 3: return 1;
		case 4: return 2;
		default: return 0;
		}
	}
	static int indexOfBot(int diceNum, int top){
		for(int i = 0; i < 6; i++){
			if(dice[diceNum+1][i] == dice[diceNum][top]) return i;
		}
		return 0;
	}
}
