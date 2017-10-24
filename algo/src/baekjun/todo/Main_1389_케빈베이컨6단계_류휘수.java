package baekjun.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1389_ÄÉºóº£ÀÌÄÁ6´Ü°è_·ùÈÖ¼ö {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a, b;
		Node[] nodes = new Node[n+1];
		for(int i = 0 ; i < m ; i++){
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			nodes[a] = new Node(b, 1, nodes[a]);
			nodes[b] = new Node(a, 1, nodes[b]);
		}
		
		boolean[] visited;
		int[] distance;
		PriorityQueue<Vertex> q;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 1 ; i <= n ; i++){
			visited = new boolean[n+1];
			distance = new int[n+1];
			Arrays.fill(distance, n-1);
			q = new PriorityQueue<>();
			
			distance[i] = 0;
			q.offer(new Vertex(i, 0));
			
			Vertex v;
			Node node;
			while(!q.isEmpty()){
				while(visited[q.peek().to]){
					q.poll();
				}
				v = q.poll();
				visited[v.to] = true;
				
				node = nodes[v.to];
				while(node != null){
					if(!visited[node.to] && distance[node.to] > v.cost + node.cost){
						distance[node.to] = v.cost + node.cost;
						q.offer(new Vertex(node.to, distance[node.to]));
					}
					node = node.next;
				}
				
			}
			int sum = 0;
			for(int j = 1 ; j <= n ; j++){
				if(j == i) continue;
				sum += distance[j];
			}
			if(sum < min){
				min = sum;
				minIndex = i;
			} else if( sum == min && minIndex > i){
				minIndex = i;
			}
			
		}
		System.out.println(minIndex);
	}// end main
	
	static class Node{
		int to;
		int cost;
		Node next;
		public Node(int to, int cost, Node next) {
			super();
			this.to = to;
			this.cost = cost;
			this.next = next;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [to=");
			builder.append(to);
			builder.append(", cost=");
			builder.append(cost);
			builder.append(", next=");
			builder.append(next);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int to;
		int cost;
		public Vertex(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.cost-o.cost;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Vertex [to=");
			builder.append(to);
			builder.append(", cost=");
			builder.append(cost);
			builder.append("]");
			return builder.toString();
		}
		
	}

}// end class