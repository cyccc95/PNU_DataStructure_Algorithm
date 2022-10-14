package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeArray {
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
	
	public static List<String> merge(List<String> list1, List<String> list2, List<String> list3) {
		
		String[] arr1 = new String[0];
		String[] arr2 = new String[0];
		arr1 = list1.toArray(arr1);
		arr2 = list2.toArray(arr2);

		int arr3Length = arr1.length + arr2.length;
		String[] arr3 = new String[arr3Length];
		arr3 = list3.toArray(arr3);
		
		int i = 0;
	    int j = 0;
	    int k = 0;    
	    int n1 = arr1.length;
	    int n2 = arr2.length;
	    
	    while(i < n1 && j < n2) {
    		if(arr1[i].compareTo(arr2[j]) < 0) {
    			arr3[k] = arr1[i];
    			k++; i++;
    		} else if (arr1[i].compareTo(arr2[j]) > 0) {
				arr3[k] = arr2[j];
    			k++; j++;
    		} else {
    			arr3[k] = arr1[i];
    			k++; i++; j++;
    		}
	    }
	    while(i == n1 && j < n2) {
	    	arr3[k] = arr2[j];
	    	k++; j++;
	    }
	    while(i < n1 && j == n2) {
	    	arr3[k] = arr1[i];
	    	k++; i++;
	    }
	    
	    int count= 0;
	    for(int num = 0; num < arr3.length; num++) {
	    	if(arr3[num] != null) {
	    		count++;
	    	}
	    }
	    String[] result = new String[count];
	    for(int num = 0; num < result.length; num++) {
	    	result[num] = arr3[num];
	    }
	    
	    return Arrays.asList(result);
	}
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
			list1.add("서울");
			list1.add("북경");
			list1.add("상해");
			list1.add("서울");
			list1.add("도쿄");
			list1.add("도쿄");
			list1.add("뉴욕");

		List<String> list2 = new ArrayList<String>();
			list2.add("런던");
			list2.add("런던");
			list2.add("로마");
			list2.add("방콕");
			list2.add("북경");
			list2.add("북경");
			list2.add("도쿄");
			list2.add("서울");
			list2.add(1, "LA");
		
		// list sort한 후 출력
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
	    
	  	//merge
	    List<String> list3 = new ArrayList<>();
	    list3 = merge(list1, list2, list3);
	    
	    System.out.print("\n\nmergeArray::");
	    System.out.println("\nlist3::");
	    for(String city: list3) {
    	System.out.print(city+ " ");
	    }
	}
	
}

