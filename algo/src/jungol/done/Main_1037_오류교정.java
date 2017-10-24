package jungol.done;

import java.util.Scanner;

public class Main_1037_오류교정 {

	static int size;
	static int[][] map;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		size = s.nextInt();
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = s.nextInt();
			}
		}
		s.close();
		////////////////////////////////////////
		if(parityTest()) {
			System.out.println("OK");
		} else{
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(map[i][j]==0){
						map[i][j] = 1;
						if(parityTest()){
							System.out.println("Change bit ("+(i+1)+","+(j+1)+")");
							return;
						} else {
							map[i][j] = 0;
						}
					} else {
						map[i][j] = 0;
						if(parityTest()){
							System.out.println("Change bit ("+(i+1)+","+(j+1)+")");
							return;
						} else {
							map[i][j] = 1;
						}
					}
				}
			}
			System.out.println("Corrupt");
		}
		s.close();
	}

	static boolean parityTest() {
		for (int i = 0; i < size; i++) {
			int temp = 1;
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1)
					temp = temp * (-1);
			}
			if(temp == 1){
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < size; i++) {
			int temp = 1;
			for (int j = 0; j < size; j++) {
				if (map[j][i] == 1)
					temp = temp * (-1);
			}
			if(temp == 1){
				continue;
			} else {
				return false;
			}
		}
		return true;

	}
}
