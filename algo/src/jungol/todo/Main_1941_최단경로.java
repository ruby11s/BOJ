package jungol.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1941_최단경로 {
	static int vNum;
	static int lineNum;
	static HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	static PriorityQueue<Vertex> q = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		vNum = Integer.parseInt(st.nextToken());
		lineNum = Integer.parseInt(st.nextToken());
		int a, b, c;
		HashMap<Integer, Integer> tempMap;
		for (int i = 0; i < lineNum; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (map.containsKey(a)) {
				tempMap = map.get(a);
				if (tempMap.containsKey(b) && tempMap.get(b) > c) {
					tempMap.put(b, c);
				} else {
					tempMap.put(b, c);
				}
			} else {
				tempMap = new HashMap<>();
				tempMap.put(b, c);
				map.put(a, tempMap);
			}
			if (a == 1) {
				q.offer(new Vertex(b, c));
			}

		}

		Vertex pickMe;
		HashMap<Integer, Integer> first = map.get(1);
		int addibleCost;
		int preCost;
		int newCost;
		boolean fin = false;
		while (!q.isEmpty()) {
			pickMe = q.poll();
			if (pickMe.d == vNum) {
				System.out.println(first.get(vNum));
				fin = true;
				break;
			}
			if (map.containsKey(pickMe.d)) {
				tempMap = map.get(pickMe.d); // 새롭게 선택된 정점
				for (Integer dest : tempMap.keySet()) {
					addibleCost = tempMap.get(dest);
					if (first.containsKey(dest)) {
						preCost = first.get(dest);
						newCost = addibleCost + pickMe.c;
						if (preCost > newCost) {
							first.put(dest, newCost); // update
							q.offer(new Vertex(dest, newCost));
						}
					} else {
						first.put(dest, addibleCost+pickMe.c);
						q.offer(new Vertex(dest, addibleCost+pickMe.c)); // newly added
					}
				}
			}
		}
		if (!fin) {
			System.out.println(first.get(vNum));
		}

	}// end main

	static class Vertex implements Comparable<Vertex> {
		int d;
		int c;

		public Vertex(int d, int c) {
			super();
			this.d = d;
			this.c = c;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.c - o.c;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Vertex [d=");
			builder.append(d);
			builder.append(", c=");
			builder.append(c);
			builder.append("]");
			return builder.toString();
		}

	}

}// end class
