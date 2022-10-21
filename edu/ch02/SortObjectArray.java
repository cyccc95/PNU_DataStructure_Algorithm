package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class SortObjectArray {

	public static void main(String[] args) {
//		String[] s = { "sort", "string", "array" };
//		Arrays.sort(s);
//		Arrays.sort(s, Comparator.naturalOrder());
//		Arrays.sort(s, Comparator.reverseOrder()); 
		
		/*
		Arrays.sort(s, new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        return o2.compareTo(o1);            // 내림차순으로 정렬
		    }
		});
		*/
//		s = Arrays.stream(s).sorted().toArray(String[]::new);	
//		s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//		Collections.sort(Arrays.asList(s));
		
		Fruit[] arr = {
		        new Fruit("사과", 200),
		        new Fruit("키위", 500),
		        new Fruit("오렌지", 200),
		        new Fruit("바나나", 50),
		        new Fruit("수박", 880),
		        new Fruit("체리", 10)
		};
	    System.out.println();
	    System.out.println("정렬전:: lst1");
	    for (Fruit x: arr)
	    	System.out.print(" " + x);
	    
	  //구현 - 정렬
	    System.out.println();
	    System.out.println("정렬후:: lst1");
	    Arrays.sort(arr);
	    for ( Fruit x: arr)
	    	System.out.print(" " + x);
	    
		ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
		ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
		lst2.add(new Fruit("복숭아", 200));
		lst2.add(new Fruit("포도", 300));
		lst2.add(new Fruit("참외", 100));
		lst2.add(new Fruit("딸기", 50));
		lst2.add(new Fruit("블루베리", 500));
		lst2.add(new Fruit("구지뽕", 300));
		System.out.println();
		System.out.println("정렬전:: lst2");
	    for ( Fruit x: lst2)
	    	System.out.print(" " + x);
//	    Arrays.sort(lst2);
	    Collections.sort(lst2);
		System.out.println();
		System.out.println("정렬후:: lst2");
	    for ( Fruit x: lst2)
	    	System.out.print(" " + x);
	    
	    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
		
		Iterator<Fruit> iter1 = lst1.iterator();
		Iterator<Fruit> iter2 = lst2.iterator();
		
	//구현- merge를 iterator 사용

		System.out.println();
	    System.out.println("merge:: ");
	    
	    Fruit f1 = iter1.hasNext() ? iter1.next() : null;
	    Fruit f2 = iter2.hasNext() ? iter2.next() : null;
	    while (f1 != null && f2 != null) {
	    	if (f1.compareTo(f2) < 0) {
	    		lst3.add(f1);
	    		f1 = iter1.hasNext() ? iter1.next() : null;
	    	} else if (f1.compareTo(f2) > 0) {
	    		lst3.add(f2);
	    		f2 = iter2.hasNext() ?  iter2.next() : null;
	    	} else {
	    		lst3.add(f1);
	    		f1 = iter1.hasNext() ? iter1.next() : null;
	    		f2 = iter2.hasNext() ?  iter2.next() : null;
	    	}
	    }
	    while (f1 != null) {
	    	lst3.add(f1);
	    	f1 = iter1.hasNext() ? iter1.next() : null;
	    }
	    while (f2 != null) {
	    	lst3.add(f2);
	    	f2 = iter2.hasNext() ? iter2.next() : null;
	    }
	    
	    for (int i = 0; i < lst3.size(); i++) {
			System.out.print(lst3.get(i) + " ");
			if (i == lst3.size() / 2 - 1) {
				System.out.println();
			}
	    }
	    
//	    Fruit newFruit = new Fruit("참외", 100);
//	    //binary search - Comparator를 사용한 구현
//	    
//
//	    System.out.println();
//	    if (Collections.binarySearch(lst3, newFruit, cc) < 0)
//			System.out.println("조회결과 없다");
//	    else System.out.println("조회 결과 "+ newFruit);
	}

}
