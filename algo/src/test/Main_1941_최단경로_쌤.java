package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1941_최단경로_쌤 {

	static class Node{
		int to;
		int weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{

		int index;
		int distance;
		
		public Vertex(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.distance - o.distance;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br 
		 	= new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		    
	     int count = Integer.parseInt(st.nextToken());
	     int edgeCount = Integer.parseInt(st.nextToken());
	     
	     final int INFINITY = Integer.MAX_VALUE;
	     
	     Node[] adjList = new Node[count];
	     int[] distance = new int[count];
	     boolean[] visited = new boolean[count];
	     PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
	     
	     // adjList만들기
	     for(int i=0; i<edgeCount; ++i){
	    	 st = new StringTokenizer(br.readLine());	     
	    	 int from = Integer.parseInt(st.nextToken())-1;
		     int to = Integer.parseInt(st.nextToken())-1;
		     int weight = Integer.parseInt(st.nextToken());
		     
		     adjList[from] = new Node(to, weight, adjList[from]);
	     }
	     
	     int min=0,current=0,end=count-1;
	     Arrays.fill(distance, INFINITY);
	     distance[0] = 0;
	     queue.offer(new Vertex(0,0));
	     
	     while(!queue.isEmpty()){
	    	 Vertex v = queue.poll();
	    	 current = v.index;
	    	 min = v.distance;
	    	 
	    	 if(current == end){
	    		 break;
	    	 }
	    	 
	    	 if(visited[current]){
	    		 continue;
	    	 }
	    	 
	    	 visited[current] = true;
	    	 Node n = adjList[current];
	    	 while(n != null){
	    		 if(!visited[n.to] && min + n.weight < distance[n.to]){
	    			 distance[n.to] = min + n.weight;
	    			 queue.offer(new Vertex(n.to, distance[n.to]));
	    		 }
	    		 n = n.next;
	    	 }
	     }
	     
	     System.out.println(distance[end]);
	     
	     
	}

}















