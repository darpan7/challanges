package challenges.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @date Jul 25, 2018 2:39:14 PM
 * @author Darpan Shah
 */
/*
Input:
6
1 1
1 2
3 1
2 1
2 1
3 2
Output:
1
0
 */
public class FrequencyQueries {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		List<Integer> output = new ArrayList<>();
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> times = new HashMap<>();
		while (T > 0) {
			int id = scanner.nextInt();
			int x = scanner.nextInt();
			switch (id) {
				case 1:
					Integer t = map1.get(x); 
					if (t == null) {
						t = 1;
						map1.put(x, t);
						Integer t_nwplc = times.get(t);
						if (t_nwplc == null) {
							t_nwplc = 0;
						}
						times.put(t, t_nwplc + 1);
					} else {
						Integer t_old = times.get(t); 
						times.put(t, --t_old);
						if(times.get(t) <= 0){
							times.remove(t);
						}
						map1.put(x, ++t); 
						Integer t_nwplc = times.get(t);
						if(t_nwplc == null){
							t_nwplc = 0; 
						}
						times.put(t, t_nwplc + 1);
					}
					break;
				case 2:
					Integer t1 = map1.get(x);
					if (t1 != null && t1 > 0) {
						times.put(t1, times.get(t1) - 1);
						if(times.get(t1) <= 0){
							times.remove(t1);
						}
						if((t1-1) == 0){
							map1.remove(x);
						}else{
							map1.put(x, --t1);							
							Integer t_nwplc = times.get(t1);
							if(t_nwplc == null){
								t_nwplc = 0;
							}
							times.put(t1, t_nwplc + 1);
						}
					}
					break;
				case 3:
					if (times.get(x) != null)
						output.add(1);
					else
						output.add(0);
					break;
				default:
					break;
			}
			System.out.println("map1: "+ map1);
			System.out.println("times: "+ times);
			--T;
		}
		
		System.out.println(output);
		scanner.close();

	}

}
