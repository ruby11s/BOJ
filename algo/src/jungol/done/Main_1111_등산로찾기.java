package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1111_등산로찾기 {
    static int cnt;
    static int[] summit = new int[2];
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[][] distance;
    static int[] minStart = new int[2];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        cnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        summit[0] = Integer.parseInt(st.nextToken());
        summit[1] = Integer.parseInt(st.nextToken());
        map = new int[cnt+2][cnt+2];
        visited = new boolean[cnt+2][cnt+2];
        distance = new int[cnt+2][cnt+2];
        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= cnt; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        minStart[0] = summit[0];
        minStart[1] = summit[1];
        distance[summit[0]][summit[1]] = 0;
        int[] minPos = new int[2];
        while (true) {
 
            int minDis = Integer.MAX_VALUE;
            for (int m = 0; m < cnt+2; m++) {
                for (int n = 0; n < cnt+2; n++) {
                    if (!visited[m][n] && distance[m][n] < minDis) {
                        minDis = distance[m][n];
                        minPos[0] = m;
                        minPos[1] = n;
                    }
                }
            }
            visited[minPos[0]][minPos[1]] = true;
            if(minPos[0] == 0 || minPos[0] == cnt+1 || minPos[1] == 0 || minPos[1] == cnt+1){
                System.out.println(distance[minPos[0]][minPos[1]]);
                return;
            }
 
            // update
            int newX;
            int newY;
            for (int k = 0; k < 4; k++) {
                newX = minPos[0] + dir[k][0];
                newY = minPos[1] + dir[k][1];
                if (newX >= 0 && newY >= 0 && newX < cnt+2 && newY < cnt+2 && !visited[newX][newY]) {
                        int newDis = calDis(minPos, newX, newY);
                        if (distance[newX][newY] > distance[minPos[0]][minPos[1]] + newDis) {
                            distance[newX][newY] = distance[minPos[0]][minPos[1]] + newDis;
                        }
                     
                }
            }
 
        }
 
    }// end main
 
    private static int calDis(int[] minPos, int newX, int newY) {
        int oldDis = map[minPos[0]][minPos[1]];
        int newDis = map[newX][newY];
        if (oldDis > newDis) {
            return (oldDis - newDis) * (oldDis - newDis);
        } else if (oldDis == newDis) {
            return 0;
        } else {
            return newDis - oldDis;
        }
    }
 
    private static void init() {
        for (int i = 0; i < cnt+2; i++) {
            for (int j = 0; j < cnt+2; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }
 
}// end class
