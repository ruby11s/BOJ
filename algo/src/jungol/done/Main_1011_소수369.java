package jungol.done;

import java.util.Scanner;

public class Main_1011_¼Ò¼ö369 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		
		int[] mem = new int[n];
		
		for(int i = 1 ; i <= m ; i++){
			if(prime(i)){
				mem[(i-1)%n]++;
			}
		}
		System.out.println(mem[k]);
		s.close();
		
	}
	
	static boolean prime(int a){
		if(a == 1) return false;
		if(a == 2) return true;
		for(int i = 2 ; i <= Math.pow(a, 0.5) ; i++){
			if(a%i == 0) return false;
		}
		return true;
	}

}
