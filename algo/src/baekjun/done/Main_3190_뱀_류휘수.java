package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_��_���ּ� {
	static int N;
	static int K;
	static int[][] map;
	static int L;
	static Queue<Object[]> queue = new LinkedList<>();
	static Deque<int[]> snake = new LinkedList<>(); //������ǥ
	static Object[] next = new Object[2];
	static int second;
	static int[] head;
	static int[] curDir = {0, 1};
	static int newX;
	static int newY;
	static boolean fin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		st = new StringTokenizer(br.readLine().trim());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int temp1 = Integer.parseInt(st.nextToken()) - 1;
			int temp2 = Integer.parseInt(st.nextToken()) - 1;
			map[temp1][temp2] = 2; // ���
		}
		st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			Integer temp1 = Integer.parseInt(st.nextToken());
			Character temp2 = st.nextToken().charAt(0);
			queue.offer(new Object[] { temp1, temp2 });
		}
		////////////////////////////////////////////
		map[0][0] = 1; // ���� ù ��ġ
		snake.offerFirst(new int[]{0,0});
		int tempV = 0;
		O: while (!queue.isEmpty()) {
			next = queue.poll();
			int nextSecond = (Integer) next[0];
			char nextDir = (Character) next[1];
			while (second < nextSecond) {
//				for(int[] i : map){
//					System.out.println(Arrays.toString(i));
//				}
//				System.out.println(second);
//				System.out.println("===================");
				second++;
				head = snake.peekFirst();
				newX = head[0] + curDir[0];
				newY = head[1] + curDir[1];
				if (newX >= 0 && newY >= 0 && newX < N && newY < N) { // ���� �ƴ϶��
					tempV = map[newX][newY];
					if (tempV == 2) { // ������
						map[newX][newY] = 1;
						snake.offerFirst((new int[]{newX, newY})); // �Ӹ� �߰�
					} else if(tempV == 0){ //���̶��
						map[newX][newY] = 1;
						snake.offerFirst((new int[]{newX, newY})); // �Ӹ� �߰�
						int[] tail = snake.pollLast(); // ��������;
						map[tail[0]][tail[1]] = 0;
					} else { // �����̶��
						fin = true;
						break O;
					}
				} else { // ���̶��
					fin = true;
					break O;
				}
			}
			if(nextDir == 'L'){
				if(curDir[0] == 0 && curDir[1] == 1){// �����̵� ���̾��ٸ�
					curDir[0] = -1;	curDir[1] = 0; // ������
				} else if(curDir[0] == 0 && curDir[1] == -1){// �����̵����̾��ٸ�
					curDir[0] = 1; curDir[1] = 0; // ������
				} else if(curDir[0] == -1 && curDir[1] == 0){// �����̵����̾��ٸ�
					curDir[0] = 0; curDir[1] = -1; // ����
				} else { // �����̵����̾��ٸ�
					curDir[0] = 0; curDir[1] = 1; // ���
				}
			} else if(nextDir == 'D'){
				if(curDir[0] == 0 && curDir[1] == 1){// �����̵� ���̾��ٸ�
					curDir[0] = 1;	curDir[1] = 0; // ������
				} else if(curDir[0] == 0 && curDir[1] == -1){// �����̵����̾��ٸ�
					curDir[0] = -1; curDir[1] = 0; // ������
				} else if(curDir[0] == -1 && curDir[1] == 0){// �����̵����̾��ٸ�
					curDir[0] = 0; curDir[1] = 1; // ������
				} else { // �����̵����̾��ٸ�
					curDir[0] = 0; curDir[1] = -1; // ����
				}
			}
		}
		if(!fin){
			while (true) {
//				for(int[] i : map){
//					System.out.println(Arrays.toString(i));
//				}
//				System.out.println(second);
//				System.out.println("===================");
				second++;
				head = snake.peekFirst();
				newX = head[0] + curDir[0];
				newY = head[1] + curDir[1];
				if (newX >= 0 && newY >= 0 && newX < N && newY < N) { // ���� �ƴ϶��
					tempV = map[newX][newY];
					if (tempV == 2) { // ������
						map[newX][newY] = 1;
						snake.offerFirst((new int[]{newX, newY})); // �Ӹ� �߰�
					} else if(tempV == 0){ //���̶��
						map[newX][newY] = 1;
						snake.offerFirst((new int[]{newX, newY})); // �Ӹ� �߰�
						int[] tail = snake.pollLast(); // ��������;
						map[tail[0]][tail[1]] = 0;
					} else { // �����̶��
						fin = true;
						break;
					}
				} else { // ���̶��
					fin = true;
					break;
				}
			}
		}
		
		System.out.println(second);
		////////////////////////////////////////////

	}// end main

}// end class
