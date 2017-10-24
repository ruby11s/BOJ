package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_1328_ºôµù {
	static int size;
	static int[] arr;
	static int[] result;
	static int max = 0;
	static ArrayList<Integer> list;
	static ArrayList<Integer> coin;

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

		for (int i = 0; i < size - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				stack.push(i);
				while (true) {
					if (stack.isEmpty())
						break;
					if (arr[stack.peek()] < arr[i + 1]) {
						result[stack.pop()] = i + 2;
					} else{
						break;
					}
				}
			} else {
				stack.push(i);
			}
		}
//////////////////////////////////////////////////////////////////////////
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size-1; i++) {
			sb = sb.append(result[i]).append("\n");
		}
		sb = sb.append(result[result.length-1]);
		System.out.println(sb.toString());
	}

}
