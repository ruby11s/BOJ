package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1459_숫자고르기 {
	static int size;
	static int[] second;
	static int max = 0;
	static ArrayList<Integer> list;
	static ArrayList<Integer> result;
	static ArrayList<Integer> coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		second = new int[size];
		for (int i = 0; i < size; i++) {
			second[i] = Integer.parseInt(br.readLine());
		}

		list = new ArrayList<>();
		result = new ArrayList<>();
		coin = new ArrayList<>();

		for (int i = 1; i <= size; i++) {
			selectNum(i);
		}
		result.addAll(coin);
		Collections.sort(result);
		System.out.println(result.size());
		for (int i : result) {
			System.out.println(i);
		}

	}

	static void selectNum(int level) {
		if (level == second[level - 1]) {
			list.clear();
			if (!coin.contains(level)) {
				coin.add(level);
				return;
			} else {
				return;
			}
		}
		if (list.size() > 0 && list.get(0) == level) { // 순환완료
			if (!result.containsAll(list)) {
				result.addAll(list);
			}
			list.clear();
			return;
		} else if (list.contains(level)) {
			list.clear();
			return;
		} else {
			list.add(level);
			selectNum(second[level - 1]);
		}
	}

}
