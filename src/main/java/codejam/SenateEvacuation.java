package codejam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
* @date	Apr 5, 2018 4:28:01 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Senate Evacuation
https://codejam.withgoogle.com/2018/challenges/0000000000000130/dashboard/00000000000004c0
Code Jam Session 2018
Limits
1 ≤ T ≤ 50.
No party will have an absolute majority before the start of the evacuation.
1 ≤ Pi ≤ 1000, for all i.
Time limit: 30 seconds per test set.
Memory limit: 1GB.

Input:
4
2
2 2
3
3 2 2
3
1 1 2
3
2 3 1
Output:
Case #1: AB BA
Case #2: AA BC C BA
Case #3: C C AB
Case #4: BA BB CA
*/
public class SenateEvacuation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			Party[] parties = new Party[n];
			char name = 'A';
			int total = 0;
			for(int i=0; i<n; i++){
				int nparty = scanner.nextInt();
				total += nparty;
				parties[i] = new Party(String.valueOf(name), nparty);
				name++;
			}
			int mod = (total%2);
			int evacuation = (total/2) + mod;
			sort(parties);
			StringBuilder sb = new StringBuilder();
			int done = 0;
			for(int i=0; i<evacuation; i++){
				int sentr = parties[0].senators;
				if(sentr >= 2){
					total = total - 2;
					sentr -= 2;
					parties[0].senators = sentr;
					sb.append(parties[0].name + parties[0].name); sb.append(" ");
					++done;
				}else if(sentr == 1){
					break;
				}else{
					continue;
				}
				sort(parties);
			}
			String hold = null;
			boolean firstodd = true;
			for(int i=done; i<evacuation; i++){
				int sentr = parties[0].senators;
				if(total%2==0){
					if(hold == null){
						hold = parties[0].name;
						--i;
						parties[0].senators = 0;
					}else{
						sb.append(hold + parties[0].name); sb.append(" ");
						hold = null;
						total -= 2;
					}
					parties[0].senators = 0;
				}else if(firstodd){
					sb.append(parties[0].name); sb.append(" ");
					hold = null;
					total -= 1;
					firstodd = false;
				}
			}
			System.out.println(sb.toString().trim());
			--T;
		}
		scanner.close();
	}
	public static void sort(Party[] parties){
		Arrays.sort(parties, new Comparator<Party>(){
			@Override
			public int compare(Party o1, Party o2) {
				return o2.senators - o1.senators;
			}
			
		});
	}
	
	static class Party{
		String name;
		int senators;
		
		public Party(String name, int senators){
			this.name = name;
			this.senators = senators;
		}
	}
}
