package baekjun.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main_10875_뱀2_류휘수 {
	static int L, N;
	static int K;
	static long second;
	static int[][] dir = new int[][]{
		{0, 1},		//동
		{0, -1},	//서
		{1, 0},		//남
		{-1,0}		//북
	};
	static int curDir;
	static int hRow;
	static int hCol;
	static HashMap<Integer, ArrayList<Sbody>> v = new HashMap<>();
	static HashMap<Integer, ArrayList<Sbody>> h = new HashMap<>();
	static boolean more = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		Sbody first = new Sbody(L,L,L,L,0,'h', L);
		ArrayList<Sbody> list = new ArrayList<>();
		list.add(first);
		h.put(L, list);
		hRow = L;
		hCol = L;
		
		list = new ArrayList<>();
		first = new Sbody(-1,0,-1,2*L,0,'h',-1);
		list.add(first);
		h.put(first.vOrhValue, list);
		list = new ArrayList<>();
		first = new Sbody(0, 2*L+1, 2*L, 2*L+1, 2, 'v', 2*L+1);
		list.add(first);
		v.put(first.vOrhValue, list);
		list = new ArrayList<>();
		first = new Sbody(2*L+1, 0, 2*L+1, 2*L, 1, 'h',2*L+1);
		list.add(first);
		h.put(first.vOrhValue, list);
		list = new ArrayList<>();
		first = new Sbody(0,-1,2*L,-1,3,'v',-1);
		list.add(first);
		v.put(first.vOrhValue, list);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int t = Integer.parseInt(st.nextToken());
			int nextDirection = turn(st.nextToken().charAt(0));
			Sbody add = new Sbody();
			add.headRow = hRow + dir[curDir][0];
			add.headCol = hCol + dir[curDir][1];
			add.tailRow = hRow + dir[curDir][0]*t;
			add.tailCol = hCol + dir[curDir][1]*t;
			int tempSecond = Integer.MAX_VALUE;
			// head가 row, col 모두 작게 유지
			if(add.headRow > add.tailRow){
				int temp = add.headRow;
				add.headRow = add.tailRow;
				add.tailRow = temp;
			}
			if(add.headCol > add.tailCol){
				int temp = add.headCol;
				add.headCol = add.tailCol;
				add.tailCol = temp;
			}
			add.direc = curDir;
			add.vOrh = (curDir == 0 || curDir == 1) ? 'h' : 'v';
			add.vOrhValue = (add.vOrh == 'h') ? add.headRow:add.headCol;
			
			boolean breakIntoBody = false;
			
			if(add.vOrh == 'h'){ // 후보 바디가 수평
				if(h.containsKey(add.vOrhValue)){ // 후보 바디와 같은 행에 있는 바디가 존재하면
					for(Sbody body : h.get(add.vOrhValue)){
						if(add.direc == 0){ // ||-> h t
							if(body.headCol > add.tailCol || add.headCol > body.tailCol) continue;
							else { // 동
								int sec = body.headCol - (add.headCol-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else { // h t <- ||
							if(body.headCol > add.tailCol || body.tailCol<add.headCol) continue;
							else {
								int sec = add.tailCol - (body.tailCol -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						}
					}
				} else { // 후보 바디와 같은 행에 있는 수평 바디가 없음
					
				}
				
				// 교차 검사 // 수평 후보와 수직 바디
				for(Integer ii : v.keySet()){
					list = v.get(ii);
					for(Sbody body : list){
						if(body.headRow <= add.vOrhValue && add.vOrhValue <= body.tailRow
								&& add.headCol <= body.vOrhValue && body.vOrhValue <= add.tailCol){
							if(add.direc == 0){
								int sec = body.vOrhValue - (add.headCol-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							} else {
								int sec = add.tailCol - (body.vOrhValue -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else {
							continue;
						}
					}
				}
				
			} else if(add.vOrh == 'v'){
				if(v.containsKey(add.vOrhValue)){ // 후보 바디와 같은 열에 있는 바디가 존재하면
					for(Sbody body : v.get(add.vOrhValue)){
						if(add.direc == 2){ // 남으로 
							if(body.headRow > add.tailRow || add.headRow>body.tailRow) continue;
							else { // 종료
								int sec = body.headRow - (add.headRow-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else { // 북으로
							if(body.headRow > add.tailRow || body.tailRow<add.headRow) continue;
							else {
								int sec = add.tailRow - (body.tailRow -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						}
					}
				} else { // 후보 바디와 같은 열에 있는 수직 바디가 없음
					
				}
				
				// 교차 검사 수직 add 와 수평 body
				for(Integer ii : h.keySet()){
					list = h.get(ii);
					for(Sbody body : list){
						if(body.headCol <= add.vOrhValue && add.vOrhValue <= body.tailCol
								&& add.headRow <= body.vOrhValue && body.vOrhValue <= add.tailRow){
							if(add.direc == 2){
								int sec = body.vOrhValue - (add.headRow-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							} else {
								int sec = add.tailRow - (body.vOrhValue -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else {
							continue;
						}
					}
				}
			}
			
			if(breakIntoBody){
				second = second + tempSecond;
				more = false;
				break;
			} else {
				second = second + t;
				curDir = nextDirection;
				if(add.vOrh == 'v'){
					if(v.containsKey(add.vOrhValue)){
						v.get(add.vOrhValue).add(add);
					} else {
						list = new ArrayList<>();
						list.add(add);
						v.put(add.vOrhValue, list);
					}
				} else {
					if(h.containsKey(add.vOrhValue)){
						h.get(add.vOrhValue).add(add);
					} else {
						list = new ArrayList<>();
						list.add(add);
						h.put(add.vOrhValue, list);
					}
				}
				hRow = (add.direc == 0 || add.direc == 2) ? add.tailRow : add.headRow;
				hCol = (add.direc == 0 || add.direc == 2) ? add.tailCol : add.headCol;
			}
			
			
		}
		
		while(more) {
			int t = 2*L+1;
			Sbody add = new Sbody();
			add.headRow = hRow + dir[curDir][0];
			add.headCol = hCol + dir[curDir][1];
			add.tailRow = hRow + dir[curDir][0]*t;
			add.tailCol = hCol + dir[curDir][1]*t;
			int tempSecond = Integer.MAX_VALUE;
			// head가 row, col 모두 작게 유지
			if(add.headRow > add.tailRow){
				int temp = add.headRow;
				add.headRow = add.tailRow;
				add.tailRow = temp;
			}
			if(add.headCol > add.tailCol){
				int temp = add.headCol;
				add.headCol = add.tailCol;
				add.tailCol = temp;
			}
			add.direc = curDir;
			add.vOrh = (curDir == 0 || curDir == 1) ? 'h' : 'v';
			add.vOrhValue = (add.vOrh == 'h') ? add.headRow:add.headCol;
			
			boolean breakIntoBody = false;
			
			if(add.vOrh == 'h'){ // 후보 바디가 수평
				if(h.containsKey(add.vOrhValue)){ // 후보 바디와 같은 행에 있는 바디가 존재하면
					for(Sbody body : h.get(add.vOrhValue)){
						if(add.direc == 0){ // ||-> h t
							if(body.headCol > add.tailCol || add.headCol > body.tailCol) continue;
							else { // 동
								int sec = body.headCol - (add.headCol-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else { // h t <- ||
							if(body.headCol > add.tailCol || body.tailCol<add.headCol) continue;
							else {
								int sec = add.tailCol - (body.tailCol -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						}
					}
				} else { // 후보 바디와 같은 행에 있는 수평 바디가 없음
					
				}
				
				// 교차 검사 // 수평 후보와 수직 바디
				for(Integer ii : v.keySet()){
					list = v.get(ii);
					for(Sbody body : list){
						if(body.headRow <= add.vOrhValue && add.vOrhValue <= body.tailRow
								&& add.headCol <= body.vOrhValue && body.vOrhValue <= add.tailCol){
							if(add.direc == 0){
								int sec = body.vOrhValue - (add.headCol-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							} else {
								int sec = add.tailCol - (body.vOrhValue -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else {
							continue;
						}
					}
				}
				
			} else if(add.vOrh == 'v'){
				if(v.containsKey(add.vOrhValue)){ // 후보 바디와 같은 열에 있는 바디가 존재하면
					for(Sbody body : v.get(add.vOrhValue)){
						if(add.direc == 2){ // 남으로 
							if(body.headRow > add.tailRow || add.headRow>body.tailRow) continue;
							else { // 종료
								int sec = body.headRow - (add.headRow-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else { // 북으로
							if(body.headRow > add.tailRow || body.tailRow<add.headRow) continue;
							else {
								int sec = add.tailRow - (body.tailRow -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						}
					}
				} else { // 후보 바디와 같은 열에 있는 수직 바디가 없음
					
				}
				
				// 교차 검사 수직 add 와 수평 body
				for(Integer ii : h.keySet()){
					list = h.get(ii);
					for(Sbody body : list){
						if(body.headCol <= add.vOrhValue && add.vOrhValue <= body.tailCol
								&& add.headRow <= body.vOrhValue && body.vOrhValue <= add.tailRow){
							if(add.direc == 2){
								int sec = body.vOrhValue - (add.headRow-1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							} else {
								int sec = add.tailRow - (body.vOrhValue -1);
								if(sec < tempSecond){
									tempSecond = sec;
									breakIntoBody = true;
								}
							}
						} else {
							continue;
						}
					}
				}
			}
			
			if(breakIntoBody){
				second = second + tempSecond;
				break;
			} else {
			}
			
			
		}
		
		
		////////////////////////////////////////////
		
		System.out.println(second);
		
		////////////////////////////////////////////
 
	}// end main
	
	static int turn(char direction){
		if(direction == 'L'){
			switch(curDir){
			case 0: return 3;
			case 1: return 2;
			case 2: return 0;
			case 3: return 1;
			default : return 4;
			}
		} else if(direction == 'R'){
			switch(curDir){
			case 0: return 2;
			case 1: return 3;
			case 2: return 1;
			case 3: return 0;
			default : return 4;
			}
		} else return 4;
	}
	
	static class Sbody{
		int headRow;
		int headCol;
		int tailRow;
		int tailCol;
		int direc;
		char vOrh;
		int vOrhValue;
		public Sbody(int headRow, int headCol, int tailRow, int tailCol, int direc, char vOrh, int vOrhValue) {
			super();
			this.headRow = headRow;
			this.headCol = headCol;
			this.tailRow = tailRow;
			this.tailCol = tailCol;
			this.direc = direc;
			this.vOrh = vOrh;
			this.vOrhValue = vOrhValue;
		}
		public Sbody() {
			super();
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Sbody [headRow=");
			builder.append(headRow);
			builder.append(", headCol=");
			builder.append(headCol);
			builder.append(", tailRow=");
			builder.append(tailRow);
			builder.append(", tailCol=");
			builder.append(tailCol);
			builder.append(", direc=");
			builder.append(direc);
			builder.append(", vOrh=");
			builder.append(vOrh);
			builder.append(", vOrhValue=");
			builder.append(vOrhValue);
			builder.append("]");
			return builder.toString();
		}
	}
	
	static void swap(int a, int b){
		int temp;
		temp = a;
		a = b;
		b = temp;
	}
 
}// end class