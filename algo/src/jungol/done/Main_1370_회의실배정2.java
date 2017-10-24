package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1370_회의실배정2 {
	static int cnt;
	static int[][] schedule;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cnt = Integer.parseInt(st.nextToken());
		schedule = new int[cnt][3];
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(schedule, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int lastIndex = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(schedule[0][0]);
		for(int i = 1 ; i < cnt ; i++){
			if(schedule[lastIndex][2] <= schedule[i][1]){
				lastIndex = i;
				list.add(schedule[i][0]);
			}
		}
		System.out.println(list.size());
		for(int i : list){
			System.out.print(i+" ");
		}
	}
	

}
