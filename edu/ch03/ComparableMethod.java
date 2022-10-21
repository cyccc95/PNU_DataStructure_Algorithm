package ch03;

import ch02.Fruit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparableMethod {
	public static void main(String[] args) {
//		System.out.println("======스트링::");
//		String[] s = { "sort", "string", "array" };
//		
//		System.out.println("======sort::");
//		Arrays.sort(s);
//		System.out.println(Arrays.toString(s));
//	
//		System.out.println("======sort reverseOrder::");
//		Arrays.sort(s, Comparator.reverseOrder()); // String -> Comparator -> Collections.reverseOrder
//		System.out.println(Arrays.toString(s));
//		
//		System.out.println("======내림차순 정렬");
//		Arrays.sort(s, new Comparator<String>() {
//		    @Override
//		    public int compare(String o1, String o2) {
//		        return o2.compareTo(o1);            // 내림차순으로 정렬
//		    }
//		});
//		System.out.println(Arrays.toString(s));
//		
//		System.out.println("======Array를 List로 바꿔서 sort::");
//		Collections.sort(Arrays.asList(s)); //s[]의 주소를 lst에서 사용하므로 변경됨
//	    for ( String city: s)
//	    	System.out.print(" " + city);	
//	    System.out.println();
//	
//		System.out.println("===Array를 List로 변경후 출력===");
//		List<String> lst = Arrays.asList(s);
//	    for ( String city: lst)
//	    	System.out.print(" " + city);	
//	    System.out.println();
//	    
//	    System.out.println("===stream으로 정렬 후 출력===");
//		s = Arrays.stream(s).sorted().toArray(String[]::new);
//		for(String str : s)
//			System.out.print(" " + str);
//		
//		System.out.println("\n===stream으로 내림차순 정렬 후 출력===");
//		s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//	    for(String str : s)
//			System.out.print(" " + str);
		
	    System.out.println("======객체::");
	    Fruit[] arr = {
		        new Fruit("사과", 200),
		        new Fruit("키위", 500),
		        new Fruit("오렌지", 200),
		        new Fruit("바나나", 50),
		        new Fruit("수박", 880),
		        new Fruit("체리", 10)
		};
	    
	    System.out.println("===가격 기준으로 오름차순 정렬===");
	    Arrays.sort(arr);
	    for(Fruit f : arr)
	    	System.out.print(" " + f);
	
	    System.out.println("\n===이름 기준으로 오름차순 정렬===");
		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
//				return o1.compareTo(o2);
				return (o1.getName()).compareTo(o2.getName());            // 내림차순으로 정렬
			}
		});
	    for(Fruit f : arr)
	    	System.out.print(" " + f);
	
		
	    System.out.println("\n===람다식===");
		Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); //Fruit에 compareTo()가 있어도 람다식 우선 적용
	    for ( Fruit city: arr)
	    	System.out.print(" " + city);

	    ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
	    ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
			lst2.add(new Fruit("복숭아", 200));
			lst2.add(new Fruit("구지뽕", 300));
			lst2.add(new Fruit("거봉", 100));
			lst2.add(new Fruit("참외", 100));
			lst2.add(new Fruit("딸기", 50));
			lst2.add(new Fruit("블루베리", 500));
			lst2.add(new Fruit("파인애플", 300));
		System.out.println();
		System.out.println("===새로운 리스트2===");
	    for ( Fruit city: lst2)
	    	System.out.print(" " + city);
	    Collections.sort(lst2);
		System.out.println();
		System.out.println("===리스트2 정렬===");
	    for ( Fruit city: lst2)
	    	System.out.print(" " + city);
	    
	    
	    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
		
		Iterator<Fruit> iter1 = lst1.iterator();
		Iterator<Fruit> iter2 = lst2.iterator();
		Fruit data1 = iter1.next();
		Fruit data2 = iter2.next();
	 
		System.out.println();
	    System.out.println("===merge:: 정렬 전===");
	    lst3.addAll(lst1);
	    lst3.addAll(lst2);
	    
	    for ( Fruit city: lst3)
	    	System.out.print(city+ " ");
	    
	    System.out.println("\n===가격 기준 정렬 후 lst3===");
	    Collections.sort(lst3);
	    for ( Fruit city: lst3)
	    	System.out.print(city+ " ");
	    
	    //binary search
	    Fruit newFruit = new Fruit("참외", 100);
	    Comparator<Fruit> cc = new Comparator<Fruit>() {
	        public int compare(Fruit u1, Fruit u2) {
	        	return u1.compareTo(u2);
	        }
	    };
	    
	    System.out.println();
	    int result = Collections.binarySearch(lst3, newFruit, cc);
			System.out.println("binarySearch 조회결과 exist : " + result);

    
	}
}
