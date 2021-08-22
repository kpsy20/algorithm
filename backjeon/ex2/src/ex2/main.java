package ex2;
import java.util.*;
import java.io.*;

public class main {
	static int res = 0;
	public static void gett(int[][] item, int[] bag, int k) {
		if(item.length == 0 || bag[0] + item[0][0] > k){
			if(res < bag[1]) {
				res = bag[1];
			}
			return;
		}
		int[][] item2 = new int[Math.max(item.length-1, 0)][2];
		//System.out.println(res);
		System.arraycopy(item, 1, item2, 0, Math.max((item.length-1), 0));
		if(bag[0] + item[0][0] <= k) {
			
			bag[0] = bag[0] + item[0][0];
			bag[1] = bag[1] + item[0][1];
			//System.out.println("PUT IN");
			gett(item2, bag, k);
			
			bag[0] = bag[0] - item[0][0];
			bag[1] = bag[1] - item[0][1];
		}
		//System.out.println("NEXT LEVEL");
		gett(item2, bag, k);
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int [][] item = new int [N][2];
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine());
				int w = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				item[i][0] = w;
				item[i][1] = p;
			}
			Arrays.sort(item);
			int[] bag = {0, 0};
			gett(item, bag, K);
			System.out.println(res);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
