package challenges.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
* @date	Jul 24, 2018 4:32:34 PM
* @author Darpan Shah
*/
/*
Input:
1
4 1
1 2 2 4
Output:
2
*/
public class CountTriplets {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			Map<Long, List<Integer>> mpNeed = new HashMap<>();
			long n = scanner.nextLong(); long r = scanner.nextLong();
			for(int i=0; i<n; i++){
				 long x = scanner.nextLong();
				 long need = r*x;
				 List<Integer> list = mpNeed.getOrDefault(need, new ArrayList<>());
				 if(list.isEmpty())
					 mpNeed.put(need, list);
				 list.add(i);
				 
				 List<Integer> index = mpNeed.get(x);
				 if(index!=null){
					 for(int id: index){
						 if(id==i)
							 continue;
						 List<Integer> lst = map.getOrDefault(id, new ArrayList<>());
						 if(lst.isEmpty())
							 map.put(id, lst);
						 lst.add(i);
					 }
				 }
				 
			}
			Queue<Integer> queue = new LinkedList<>();
			for(int id: map.keySet()){
				queue.offer(id);
			}
			System.out.println("Indices: " + map);
			System.out.println("Need: " + mpNeed);
			System.out.println("Queue: " + queue);
			long count = 0;
			while(!queue.isEmpty()){
				int x = queue.poll();
				List<Integer> list = map.get(x);
				if(list == null)
					continue;
				for(int y: list){
					if(map.containsKey(y)){
						count += map.get(y).size();
					}
				}
			}
			System.out.println(count);
			--T;
		}
		scanner.close();

	}

}
