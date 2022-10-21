package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
public class SortArray {
    public static String[] removeElement1(String[] arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(item);
        return list.toArray(String[]::new);
    }
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");

		list.add(1, "LA");
		
		//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩
		System.out.println("collection.sort()::");
	    System.out.println("\n오름차순::");
		Collections.sort(list);
	    for ( String city: list)
	    	System.out.print(city + "\t");
	    
	    System.out.println("\n\n내림차순::");
	    Collections.sort(list, Collections.reverseOrder());
	    for ( String city: list)
	    	System.out.print(city + "\t");

	    // 배열로 변환
	    String cities[] = new String[0];
	    cities = list.toArray(cities);
	    
	    System.out.println("\n\n배열로 변환 후 출력::");
	    System.out.println(Arrays.toString(cities));
	    
	    System.out.println("\n배열을 오름차순 정렬::");
	    for (int i = 0; i < cities.length; i++) {
			for (int j = 0; j < cities.length; j++) {
				if (cities[i].compareTo(cities[j]) < 1) {
					String temp;
					temp = cities[i];
					cities[i] = cities[j];
					cities[j] = temp;
				}
			}
		}
	    for (String city : cities) {
			System.out.print(city + "\t");
		}
	    
	    // 다시 list로 변환
	    List<String> list2 = new ArrayList<>(Arrays.asList(cities));
	    //error : UnsupportedOperationException
	    // Arrays.asList(arr)로 만든 ArrayList의 값을 추가/변경/삭제하려고 할시 발생
	    // new ArrayList로 초기화 해주면 해결
	    
	    System.out.println("\n\nlist로 변환 후 출력::");
	    Iterator<String> iter = list2.iterator();
	    while(iter.hasNext()) {
	    	System.out.print(iter.next() + "\t");
	    }

	    //중복제거
	    System.out.println("\n\n중복제거 후 출력::");
	    
	    //중복값들을 저장할 ArrayList
	    List<String> repeat = new ArrayList<>();
	    
	    for (int i = 0; i < list2.size()-1; i++) {
			for (int j = i+1; j < list2.size(); j++) {
				if(repeat.contains(list2.get(j))) break;
				if(list2.get(i) == list2.get(j)) {
					repeat.add(list2.get(j)); break;
				}
			}
		}
	    //중복값 제거 후 다시 한개만 남도록 추가
	    list2.removeAll(repeat);
	    list2.addAll(repeat);
	    for (String city : list2) {
			System.out.print(city + "\t");
		}
	}
}
