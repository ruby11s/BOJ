package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_2261_경로찾기 {
    static int size;
    static int cnt;
    static int start, end;
    static HashMap<Integer, BigInteger> map = new HashMap<>();
    static Queue<Course> q = new LinkedList<>();
    static HashMap<Integer, ArrayList<Integer>> info = new HashMap<>();
    static boolean[] visited;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        cnt = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        BigInteger bi;
        ArrayList<Integer> al;
        for (int i = 1; i <= cnt; i++) { 
            bi = new BigInteger(br.readLine().trim(), 2);
            map.put(i, bi);
            al = new ArrayList<>();
            info.put(i, al);
        }
        st = new StringTokenizer(br.readLine().trim());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visited = new boolean[cnt+1];
         
        al = new ArrayList<>();
        al.add(start);
        Course forStart = new Course(start, al);
        q.offer(forStart);
        visited[start] = true;
        while(!q.isEmpty()){
            Course course = q.poll();
            int num = course.num;
            ArrayList<Integer> list;
            Course next;
            BigInteger targetBi = map.get(num);
            BigInteger temp;
            String binary;
            for(int i = 1 ; i <= cnt ; i++){
                if(visited[i]) continue;
                temp = targetBi.xor(map.get(i));
                binary = temp.toString(2);
                if(binary.lastIndexOf("1") == 0){
                    if(i == end){
                        for(int j : course.list){
                            System.out.print(j+" ");
                        }
                        System.out.print(i);
                        return;
                    }
                    list = new ArrayList<>();
                    list.addAll(course.list);
                    list.add(i);
                    next = new Course(i, list);
                    q.offer(next);
                    visited[i] = true;
                } 
            }
        }
        System.out.print(-1);
         
    }//end main
     
    static class Course{
        int num;
        ArrayList<Integer> list;
        public Course(int num, ArrayList<Integer> list) {
            super();
            this.num = num;
            this.list = list;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Course [num=");
            builder.append(num);
            builder.append(", list=");
            builder.append(list);
            builder.append("]");
            return builder.toString();
        }
    }
     
}// end class
