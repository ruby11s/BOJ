package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_1336_소수와함께하는여행 {
    static String start, end;
    static HashMap<Integer, Boolean> info = new HashMap<>();
    static Queue<Ele> q = new LinkedList<>();
    static boolean[] visited;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        start = st.nextToken();
        end = st.nextToken();
        String num;
        StringBuilder temp;
        q.offer(new Ele(start, 0));
        while(!q.isEmpty()){
            Ele ele = q.poll();
            num = ele.num;
            for(int i = 0 ; i < 4 ; i++){
                temp = new StringBuilder(num.toString());
                for(int j = (i==1||i==2)? 0:1 ; j <= 9 ; j= (i==3)? (j+2):(j+1)){
                    temp = temp.replace(i, i+1, j+"");
                    if(end.equals(temp.toString())) {
                        System.out.println(ele.cnt+1);
                        return;
                    }
                    if(info.get(Integer.parseInt(temp.toString())) != null
                    		&&info.get(Integer.parseInt(temp.toString()))) continue;
                    if(isPrime(Integer.parseInt(temp.toString()))){
                        q.offer(new Ele(temp.toString(), ele.cnt+1));
                    }
                }
            }
        }
         
    }//end main
     
    static boolean isPrime(int target){
        if(info.get(target) != null && info.get(target)) return true;
        if(target%2 == 0) return false;
        for(int i = 3 ; i <= Math.pow(target, 0.5); i=i+2){
            if(target%i == 0){
                return false;
            }
        }
        info.put(target, true);
        return true;
    }
     
    static class Ele{
        String num;
        int cnt;
        public Ele(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Q [num=");
            builder.append(num);
            builder.append(", cnt=");
            builder.append(cnt);
            builder.append("]");
            return builder.toString();
        }
         
    }
     
}// end class