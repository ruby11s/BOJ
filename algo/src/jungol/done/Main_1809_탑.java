package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1809_ž {
	static int size;
	static int[] arr;
	static int[] result;
	static int max = 0;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine().trim());
		arr = new int[size];
		result = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		/////////////////////////////////////////////////////////////////////////
		Stack<Integer> stack = new Stack<>();

		for (int i = size - 1; i >= 1; i--) {

			stack.push(i);
			if (arr[i - 1] >= arr[i]) {
				while (true) {
					if(stack.isEmpty()) break;
					if(arr[stack.peek()] > arr[i-1]) break;
					int temp = stack.pop();
					result[temp] = i;
				}
			} 
		}
		//////////////////////////////////////////////////////////////////////////
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size - 1; i++) {
			sb = sb.append(result[i]).append(" ");
		}
		sb = sb.append(result[result.length - 1]);
		System.out.println(sb.toString());
	}

}
