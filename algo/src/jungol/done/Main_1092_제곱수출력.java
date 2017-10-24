package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main_1092_��������� {
    static long base;
    static int exp;
    static HashMap<Integer, Boolean> info = new HashMap<>();
    static HashMap<Integer, Long> map = new HashMap<>();
    static boolean[] visited;
    static final int NUM = 20091024;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        base = Integer.parseInt(st.nextToken()) % 20091024;
        exp = Integer.parseInt(st.nextToken());
        if(exp == 0) {
            System.out.println(1);
            return;
        }
        info.put(1, true);
        map.put(1, base);
        System.out.println(sqr(exp));
         
    }// end main
 
    static long sqr(int level) {
        if (info.get(level) != null) { // ���� �� �� �̶� �ҷȴٸ�
            return map.get(level);
        }
        // ���� �� ���� �ȺҸ�
        long temp1 = sqr(level / 2);
        long temp2 = sqr(level / 2 + ((level%2==0)? 0:1));
        info.put(level, true);
        long temp3 = temp1 * temp2 % NUM;
        map.put(level, temp3);
        return temp3;
 
    }
 
}// end class
