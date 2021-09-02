package ex2;
import java.util.*;
import java.io.*;

public class main {
	public static void main(String[] args) {
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> lowQ = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(st.nextToken());
		int[][] fuel = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[2];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			fuel[i] = temp;
		}
		//for(int i=0; i<n; i++) {
			//System.out.print(fuel[i][0] + " " + fuel[i][1]);
			//System.out.println();
		//}
		Arrays.sort(fuel, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1]; //오름차순 정렬
				}
				else {
					return o1[0] - o2[0];
				}
			}
		});
		
		PriorityQueue<Integer> highQ = new PriorityQueue<>(Collections.reverseOrder());
		int idx = 0;
		int remain = 0;
		st = new StringTokenizer(br.readLine());
		int des = Integer.parseInt(st.nextToken());
		remain = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int start_fuel = 0;
		while(idx < des) {
			//System.out.println("IDX " + idx + " REMAIN " + remain + " START_FUEL " +start_fuel);
			idx = idx + remain;
			remain = 0;
			
			if(idx >= des)
				break;
			ans++;
			for(int i=start_fuel; i<n; i++) {
				if(fuel[i][0] <= idx) {
					highQ.add(fuel[i][1]);
				}
				else {
					start_fuel = i;
					break;
				}
			}
			if(highQ.size() == 0) {
				ans = -1;
				break;
			}
			remain = highQ.poll();
		}
		System.out.println(ans);
	}
		catch(Exception e) {
			
		}
	}
		
}
