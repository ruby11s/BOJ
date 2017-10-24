package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독_류휘수 {
	static int N;
	static int[] map;
	static int B;
	static int C;
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		map = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			map[i] -= B;
		}
		result = N;
		////////////////////////////////////////////
		for (int i = 0; i < N; i++) {
			if (map[i] > 0) {
				if (map[i] % C == 0) {
					result += map[i] / C;
				} else if(map[i] < C ) {
					result += 1;
				} else {
					result += map[i]/C +1;
				}
			}
		}
		////////////////////////////////////////////
		System.out.println(result);

	}// end main

}// end class
