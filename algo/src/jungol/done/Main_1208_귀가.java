package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
//시작 2017-10-07 17:04
//끝 
public class Main_1208_귀가{
    static int cnt;
    static int min = Integer.MAX_VALUE;
    static char minDepart;
    static HashMap<Character, HashMap<Character, Integer>> map = new HashMap<>();
    static HashMap<Character, Integer> distance = new HashMap<>();
    static HashMap<Character, Boolean> visited = new HashMap<>();
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        cnt = Integer.parseInt(st.nextToken());
        char depart;
        char destin;
        int length;
        HashMap<Character, Integer> temp;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            depart = st.nextToken().charAt(0);
            destin = st.nextToken().charAt(0);
            distance.put(depart, Integer.MAX_VALUE);
            distance.put(destin, Integer.MAX_VALUE);
            visited.put(depart, false);
            visited.put(destin, false);
            length = Integer.parseInt(st.nextToken());
            if (map.containsKey(depart)) {
                if (map.get(depart).containsKey(destin)) {
                    if (map.get(depart).get(destin) > length) {
                        map.get(depart).put(destin, length);
                    }
                } else {
                    map.get(depart).put(destin, length);
                }
            } else {
                temp = new HashMap<>();
                map.put(depart, temp);
                map.get(depart).put(destin, length);
            }
            if (map.containsKey(destin)) {
                if (map.get(destin).containsKey(depart)) {
                    if (map.get(destin).get(depart) > length) {
                        map.get(destin).put(depart, length);
                    }
                } else {
                    map.get(destin).put(depart, length);
                }
            } else {
                temp = new HashMap<>();
                map.put(destin, temp);
                map.get(destin).put(depart, length);
            }
        }
        ///////////////////////////////////////////////////////////////////
        temp = map.get('Z');
        for(char start : temp.keySet()){
            init();
             
            if('A' <= start && start <= 'Y'){ // 바로 소가 있는 대문자 목장
                if(temp.get(start) < min){
                    min = temp.get(start);
                    minDepart = start;
                }
            } else { // 소가 없는 소문자 목장으로 시작
                distance.put(start, temp.get(start));
                int minDis;
                char minPos = 0;
                int tempDis;
                while(true){
                    minDis = Integer.MAX_VALUE;
                    for(char dist : distance.keySet()){
                        tempDis = distance.get(dist);
                        if(!visited.get(dist) && tempDis < minDis){
                            minDis = tempDis;
                            minPos = dist;
                        }
                    }
                    visited.put(minPos, true);
                    if('A' <= minPos && minPos <= 'Y'){
                        if(minDis < min){
                            min = minDis;
                            minDepart = minPos;
                        }
                        break;
                    }
                     
                    //update;
                    for(char update : map.get(minPos).keySet() ){
                        int updateDis = map.get(minPos).get(update);
                        if(!visited.get(update) 
                        		&& distance.get(update) > distance.get(minPos) + updateDis){
                            distance.put(update, distance.get(minPos) + updateDis);
                        }
                    }
                }
            }
             
        }
         
        ///////////////////////////////////////////////////////////////////
         
        System.out.print(minDepart +" "+ min);
         
    }// end main
 
    private static void init() {
        for(char dis : distance.keySet()){
            distance.put(dis, Integer.MAX_VALUE);
        }
        for(char vis : visited.keySet()){
            visited.put(vis, false);
        }
    }
 
}// end class
