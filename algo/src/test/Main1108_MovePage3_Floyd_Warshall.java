package test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
1 2
2 4
1 3
3 1
4 3
 */
public class Main1108_MovePage3_Floyd_Warshall {

	
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(in.readLine().trim());
        final int INFINITY = 500;
        int [][] info = new int[count][2];
         
        StringTokenizer st = null;
        
        int page1 = 0, page2 = 0, endPage = 0, max = 0;
        for(int i=0; i<count; ++i){
        	st = new StringTokenizer(in.readLine().trim());
        	page1 = Integer.parseInt(st.nextToken());
        	page2 = Integer.parseInt(st.nextToken());
        	
        	// ������ ������ ã��
        	if((max=Math.max(page1, page2))>endPage){
        		endPage = max;
        	}

        	info[i][0] = page1;
        	info[i][1] = page2;
        }
        
         
        int [][] matrix = new int[endPage+1][endPage+1];
         
        for (int i = 0; i <= endPage; i++) {
            for (int j = 0; j <= endPage; j++) {
            	if (i==j){
            		continue;
            	}
                matrix[i][j] = INFINITY;
            }
        }
        
        
        // �̵������� �������� 1��.
        for(int[] a : info){
        	matrix[a[0]][a[1]] = 1;
        }       
        // �������� ���� INFINITY��. ���� �ִ� ���� 1��, I==J�� ���� 0���� ���ÿϷ�
/*  
        for(int i=0; i<matrix.length; ++i){
        	System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("==================================");*/
        
        // �����-->������-->�������� 3�� ���� ������ ����
        // ������-->�����-->�������� 3�� ���� ������ ����
		for (int k = 1; k <= endPage; k++) { // ������
	START_LOOP:	for (int i = 1; i <= endPage; i++) { // �����
				for (int j = 1; j <= endPage; j++) { // ������
					
					if(i==k){//������� �������� ������
							 //�����ϴ� ������ ���� UPDATE�� �ʿ�����Ƿ� ���� �������.
						continue START_LOOP;
					}
					if(i==j || j==k){ //������� �������� ���ٸ� �ڱ��ڽ�������
									 // �������� �������� ������ skip
						continue;
					}
					// �����(i)���� ������(j)���� ���� �����Ÿ��� �����(i)���� ������(j)���� ������(k)�� ����
					// ���� �Ÿ����� ũ�ٸ� ����(��, �������� ���� ���°��� �۴ٸ� ����)
					if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
/*		
        for(int i=0; i<matrix.length; ++i){
        	System.out.println(Arrays.toString(matrix[i]));
        }
        */
         
        double sum = 0;
        //� ���������� �ٸ� �������� �� �� ���� ���� ������ �����Ͱ� �Էµȴٰ� �����Ƿ�
        //�ᱹ �ٸ� ���������� ��� ������� ������� ��� matrix�� ��� ���� 0�� 0�� �ƴѰ����� ä����
        for (int i = 1; i <= endPage; i++) {
            for (int j = 1; j <= endPage; j++) {
                sum+=matrix[i][j];
            }
        }
//        System.out.println(sum);
        System.out.printf("%.3f",sum/((double)endPage*(endPage-1)));
    }
}