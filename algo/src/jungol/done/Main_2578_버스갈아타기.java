package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_2578_버스갈아타기 {
    static int x, y;
    static int cnt;
    static HashMap<Integer, ArrayList<Bus>> v = new HashMap<>();
    static HashMap<Integer, ArrayList<Bus>> h = new HashMap<>();
    // static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int min = Integer.MAX_VALUE;
    static Queue<Bus> q = new LinkedList<>();
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(br.readLine().trim());
        int num, x1, y1, x2, y2, dirNum;
        Bus busToBeAdded;
 
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            num = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            if (x1 == x2) { // 수직
                dirNum = x1;
                if (y1 > y2) {
                    int temp = y1;
                    y1 = y2;
                    y2 = temp;
                }
                busToBeAdded = new Bus(num, 1, dirNum, y1, y2, Integer.MAX_VALUE);
                if (!v.containsKey(dirNum)) {
                    ArrayList<Bus> temp = new ArrayList<>();
                    v.put(dirNum, temp);
                }
                v.get(dirNum).add(busToBeAdded);
            } else { // 수평
                dirNum = y1;
                if (x1 > x2) {
                    int temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                busToBeAdded = new Bus(num, 0, dirNum, x1, x2, Integer.MAX_VALUE);
                if (!h.containsKey(dirNum)) {
                    ArrayList<Bus> temp = new ArrayList<>();
                    h.put(dirNum, temp);
                }
                h.get(dirNum).add(busToBeAdded);
            }
        }
 
        st = new StringTokenizer(br.readLine().trim());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        ArrayList<Integer> endList = new ArrayList<>();
        if (h.get(startY) != null) {
            for (Bus bus : h.get(startY)) { // 수평
                if (bus.start <= startX && startX <= bus.end) {
                    bus.transfer = 1;
                    q.offer(bus);
                }
            }
        }
        if (h.get(endY) != null) {
            for (Bus bus : h.get(endY)) { // 수평
                if (bus.start <= endX && endX <= bus.end) {
                    endList.add(bus.num);
                }
            }
        }
        if (v.get(startX) != null) {
            for (Bus bus : v.get(startX)) { // 수직
                if (bus.start <= startY && startY <= bus.end) {
                    bus.transfer = 1;
                    q.offer(bus);
                }
            }
        }
        if (v.get(endX) != null) {
            for (Bus bus : v.get(endX)) { // 수직
                if (bus.start <= endY && endY <= bus.end) {
                    endList.add(bus.num);
                }
            }
        }
 
        while (!q.isEmpty()) {
            Bus bus = q.poll();
            if(endList.contains(bus.num)){
                System.out.println(1);
                return;
            }
            if (bus.dir == 1) {// 수직 버스
                if (v.get(bus.dirNum) != null) {
                    for (Bus temp : v.get(bus.dirNum)) {
                        if (!(bus.start > temp.end) && !(bus.end < temp.start) && (bus.transfer + 1) < temp.transfer) {
                            if (endList.contains(temp.num)) {
                                System.out.println(bus.transfer + 1);
                                return;
                            }
                            temp.transfer = bus.transfer+1;
                            q.offer(temp);
                        }
                    }
                }
                for (Integer row : h.keySet()) {
                    if (bus.start <= row && row <= bus.end) {
                        if (h.get(row) != null) {
                            for (Bus temp : h.get(row)) {
                                if (temp.start <= bus.dirNum && bus.dirNum <= temp.end
                                        && (bus.transfer + 1) < temp.transfer) {
                                    if (endList.contains(temp.num)) {
                                        System.out.println(bus.transfer + 1);
                                        return;
                                    }
                                    temp.transfer = bus.transfer+1;
                                    q.offer(temp);
                                }
                            }
                        }
                    }
                }
            }
            if (bus.dir == 0) {// 수평 버스
                if (h.get(bus.dirNum) != null) {
                    for (Bus temp : h.get(bus.dirNum)) {
                        if (!(bus.start > temp.end) && !(bus.end < temp.start) && (bus.transfer + 1) < temp.transfer) {
                            if (endList.contains(temp.num)) {
                                System.out.println(bus.transfer + 1);
                                return;
                            }
                            temp.transfer = bus.transfer+1;
                            q.offer(temp);
                        }
                    }
                }
                for (Integer row : v.keySet()) {
                    if (bus.start <= row && row <= bus.end) {
                        if (v.get(row) != null) {
                            for (Bus temp : v.get(row)) {
                                if (temp.start <= bus.dirNum && bus.dirNum <= temp.end
                                        && (bus.transfer + 1) < temp.transfer) {
                                    if (endList.contains(temp.num)) {
                                        System.out.println(bus.transfer + 1);
                                        return;
                                    }
                                    temp.transfer = bus.transfer+1;
                                    q.offer(temp);
                                }
                            }
                        }
                    }
                }
            }
        }
    }// end main
 
    static class Bus {
        int num;
        int dir;
        int dirNum;
        int start;
        int end;
        int transfer;
 
        public Bus(int num, int dir, int dirNum, int start, int end, int transfer) {
            super();
            this.num = num;
            this.dir = dir;
            this.dirNum = dirNum;
            this.start = start;
            this.end = end;
            this.transfer = transfer;
        }
 
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Bus [num=");
            builder.append(num);
            builder.append(", dir=");
            builder.append(dir);
            builder.append(", dirNum=");
            builder.append(dirNum);
            builder.append(", start=");
            builder.append(start);
            builder.append(", end=");
            builder.append(end);
            builder.append(", transfer=");
            builder.append(transfer);
            builder.append("]");
            return builder.toString();
        }
 
    }
}// end class
