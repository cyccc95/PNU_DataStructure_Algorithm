package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
public class IteratorMerge {
	public static String[] removeElement(String[] arr, String item) {
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]::new);
	}
	
	public static List<String> removeDuplicate(String[] arr) {
		int count = arr.length;
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			while (j < count) {
				if((arr[i]).compareTo(arr[j]) == 0) {
					arr = removeElement(arr, arr[j]);
					count--;
				} else {
					j++;
				}
			}
		}
		return Arrays.asList(arr);
	}
	
	public static void main(String[] args) throws Exception {
		List<String> list1 = new ArrayList<String>();
			list1.add("서울");
			list1.add("북경");
			list1.add("상해");
			list1.add("서울");
			list1.add("도쿄");
			list1.add("뉴욕");
			list1.add("한라산");

		List<String> list2 = new ArrayList<String>();
			list2.add("런던");
			list2.add("로마");
			list2.add("방콕");
			list2.add("북경");
			list2.add("도쿄");
			list2.add("서울");
			list2.add("홍도");
			list2.add("홍도1");
			list2.add("홍도2");
			
			list2.add(1, "LA");
			
		//
		System.out.println("collection.sort()::");
	    Collections.sort(list1);
	    System.out.println("list1::");
	    for ( String city: list1)
	    	System.out.print(city+ " ");
	    System.out.println();
	    System.out.println("list2::");
	    Collections.sort(list2);
	    for ( String city: list2)
	    	System.out.print(city+ " ");
		
		
		 // list to array
	    String[] arr1 = new String[0];
	    arr1 = list1.toArray(arr1);
	    String[] arr2 = new String[0];
	    arr2 = list2.toArray(arr2);
	    
	    // 중복제거
	    list1 = removeDuplicate(arr1);
	    list2 = removeDuplicate(arr2);
	    
	    // 중복제거 후 출력
	    System.out.print("\n\nremoveDuplicate::");
	    System.out.println("\nlist1::");
	    for(String city: list1) {
	    	System.out.print(city+ " ");
	    }
	    System.out.println("\nlist2::");
	    for(String city: list2) {
	    	System.out.print(city+ " ");
	    }

	    // merge
	    Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		ArrayList<String> list3 = new ArrayList<String>();
		
		System.out.println();
	    System.out.println("\nmerge:: ");
	    
	    String l1 = iter1.hasNext() ? iter1.next() : null;
	    String l2 = iter2.hasNext() ? iter2.next() : null;
	    while(l1 != null && l2 != null) {
	    	if (l1.compareTo(l2) < 0) {
	    		list3.add(l1);
	    		l1 = iter1.hasNext() ? iter1.next() : null;
	    	} else if (l1.compareTo(l2) > 0){
	    		list3.add(l2);
	    		l2 = iter2.hasNext() ? iter2.next() : null;
	    	} else {
	    		list3.add(l1);
	    		l1 = iter1.hasNext() ? iter1.next() : null;
	    		l2 = iter2.hasNext() ? iter2.next() : null;
	    	}
	    }
	    while (l1 != null) {
	    	list3.add(l1);
	    	l1 = iter1.hasNext() ? iter1.next() : null;
	    }
	    while (l2 != null) {
	    	list3.add(l2);
	    	l2 = iter2.hasNext() ? iter2.next() : null;
	    }

	    for ( String city: list3)
	    	System.out.print(city+ " ");
	    
	}	
}

