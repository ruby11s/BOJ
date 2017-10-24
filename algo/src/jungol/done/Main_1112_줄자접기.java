package jungol.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1112_줄자접기 {
	static double size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Double.parseDouble(br.readLine().trim());

		Queue<double[]> q = new LinkedList<>();
		StringTokenizer st = null;
		for (int i = 0; i < 3; i++) {
			double[] temp = new double[2];
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 2; j++) {
				temp[j] = Double.parseDouble(st.nextToken());
			}
			q.offer(temp);
		}
		/////////////////////////////////////////////////////////////////////////
		while(!q.isEmpty()){
			double[] target = q.poll();
			if(target[0] == target[1]) continue;
			double midTarget = (target[0]+target[1])/2;
			double midSize = size/2;
			if( midTarget < midSize){
				int sizeQ = q.size();
				boolean fin = false;
				if(sizeQ == 0) {
					sizeQ = 1;
					q.offer(target);
					fin = true;
				}
				for(int i = 0 ; i < sizeQ ; i++){
					double[] target2 = q.poll();
					if(target2[0]<midTarget){
						target2[0] = target2[0] +2*(midTarget-target2[0]);
					}
					if(target2[1]<midTarget){
						target2[1] = target2[1] +2*(midTarget-target2[1]);
					}
					target2[0] -= midTarget;
					target2[1] -= midTarget;
					if(!fin)
					q.offer(target2);
				}
				size = size - midTarget;
			} else{
				int sizeQ = q.size();
				boolean fin = false;
				if(sizeQ == 0) {
					sizeQ = 1;
					q.offer(target);
					fin = true;
				}
				for(int i = 0 ; i < sizeQ ; i++){
					double[] target2 = q.poll();
					if(target2[0]>midTarget){
						target2[0] -= 2*(target2[0]-midTarget);
					}
					if(target2[1]>midTarget){
						target2[1] -= 2*(target2[1]-midTarget);
					}
					if(!fin)
					q.offer(target2);
				}
				size -= size-midTarget;
			}
		}
		
		System.out.printf("%.1f", size);
		//////////////////////////////////////////////////////////////////////////
	}

}
