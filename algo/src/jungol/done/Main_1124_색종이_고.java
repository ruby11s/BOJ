package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1124_색종이_고 {
    static int cnt;
    static int[][] map = new int[100][100];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        cnt = Integer.parseInt(br.readLine().trim());
 
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            for (int j = row; j < row + 10; j++) {
                for (int k = col; k < col + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }
 
        for (int i = 0; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if (map[i][j - 1] >= map[i][j] && map[i][j] == 1) {
                    map[i][j] = map[i][j - 1] + 1;
                }
            }
        }
 
//      for (int j = 0; j < 100; j++) {
//          System.out.printf("%3d", j);
//      }
//      for (int i = 0; i < 100; i++) {
//          for (int j = 0; j < 100; j++) {
//              if (map[i][j] > 0) {
//                  System.out.printf("%3d", map[i][j]);
//              } else {
//                  System.out.print("   ");
//              }
//          }
//          System.out.println();
//      }
 
        int result = 100;
        int flagCnt = 0;
 
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                if (map[i][j] > 0) {
                    int flagTemp = map[i][j];
                    flagCnt = 1;
                    int index = i + 1;
                    while (index < 100 && map[index][j] >= flagTemp) {
                        flagCnt++;
                        index++;
                    }
                    index = i - 1;
                    while (index >= 0 && map[index][j] >= flagTemp) {
                        flagCnt++;
                        index--;
                    }
                    if (flagCnt * flagTemp > result) {
                        result = flagCnt * flagTemp;
                    }
                }
            }
        }
 
        System.out.println(result);
 
    }// end main
 
}// end class