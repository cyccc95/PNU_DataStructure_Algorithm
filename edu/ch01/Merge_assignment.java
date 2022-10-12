package ch01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class Merge_assignment {
	public static void main(String[] args) {
				ArrayList<Integer> list1 = new ArrayList<Integer>();
				list1.add(1);
				list1.add(3);
				list1.add(6);
				list1.add(8);
				list1.add(11);
				list1.add(15);
				list1.add(15);

				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.add(2);
				list2.add(5);
				list2.add(7);
				list2.add(9);
				list2.add(12);
				list2.add(13);
				
				//
				System.out.println("collection.sort()::");
			    Collections.sort(list1);
			    System.out.println("list1::");
			    for ( Integer city: list1)
			    	System.out.print(city+ " ");
			    System.out.println();
			    System.out.println("list2::");
			    Collections.sort(list2);
			    for ( Integer city: list2)
			    	System.out.print(city+ " ");
				ArrayList<Integer> result = new ArrayList<Integer>();
				
				System.out.println();
			    System.out.println("merge:: ");
			    
			    int i = 0;
			    int j = 0;
			    int n1 = list1.size();
			    int n2 = list2.size();
			    
			    while(i < n1 || j < n2) {
			    	if(i < n1 && j < n2) {
			    		if(list1.get(i) < list2.get(j)) {
			    			mergeList(list1,result,i);
			    			i++;
			    		} else {
			    			mergeList(list2,result,j);
			    			j++;
			    		}
			    	} else if(i < n1) {
			    		mergeList(list1,result,i);
			    		i++;
			    	} else {
			    		mergeList(list2,result,j);
			    		j++;
			    	}
			    }
			    
			    
			    for (Integer city : result) {
					System.out.print(city + " ");
				}
			    
			    
	}
	static void mergeList(List<Integer> list, List<Integer> result, int idx) {
		if(!result.contains(list.get(idx))) {
			result.add(list.get(idx));
		}
	}
	
	
}

