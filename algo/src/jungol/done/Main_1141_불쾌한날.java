package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_1141_∫“ƒË«—≥Ø {
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
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		/////////////////////////////////////////////////////////////////////////
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < size-1; i++) {
			stack.push(i);
			if (arr[i] <= arr[i + 1]) {
				while (!stack.isEmpty()) {
					if (arr[stack.peek()] <= arr[i + 1]) {
						int temp = stack.pop();
						result[temp] = (i + 1) - temp - 1;
					} else
						break;
				}
			}
		}
		stack.push(size-1);
		while (!stack.isEmpty()) {
			int temp2 = stack.pop();
			result[temp2] = (size - 1) - temp2;
		}

		//////////////////////////////////////////////////////////////////////////
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size - 1; i++) {
			sb = sb.append(result[i]).append(" ");
		}
		sb = sb.append(result[result.length - 1]);
		System.out.println(sb.toString());
		System.out.println();
		
		long resultNum = 0;
		for (long i : result) {
			resultNum += i;
		}
		System.out.println(resultNum);
	}

}
