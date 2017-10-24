package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateRandomValueTest {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("input2.txt");
		Random r = new Random();
		
		int n = r.nextInt(20000)+1;
		int m = r.nextInt(100000)+1;
		out.println(n+" "+m);
		for(int i = 0 ; i < m ; i++){
			int a = 0, b = 0;
			do{
				a = r.nextInt(n)+1;
				b = r.nextInt(n)+1;
			}while(a==b);
			int c = r.nextInt(10000)+1;
			out.println(a+" "+b+" "+c);
			out.flush();
		}
		out.close();
		
	}

}
