package common;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @date	Mar 28, 2018 10:52:13 AM
* @author Darpan Shah
*/

public class Search {
	public static int occurencesInSortedArray(int[] array, int x){
		AtomicInteger counter = new AtomicInteger(0);
		binarySearch(array, 0, array.length-1, x, counter);
		return counter.get();
	}
	public static void binarySearch(int[] array, int from, int to, int lookingFor, AtomicInteger counter){
		int middle = (from + to) >>> 1;
		int value = array[middle];
		if(from == to){
			if(array[from] == lookingFor)
				counter.incrementAndGet();
			return;
		}
		if(from>=to)
			return;
		if(value == lookingFor){
			counter.incrementAndGet();
			binarySearch(array, from, middle-1, lookingFor, counter);
			binarySearch(array, middle+1, to, lookingFor, counter);
		}else if(value < lookingFor){
			binarySearch(array, middle+1, to, lookingFor, counter);
		}else{
			binarySearch(array, from, middle-1, lookingFor, counter);
		}
	}
}
