package chapter06.A_CollectionClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// Collection Framework
// 배열 형태의 데이터를 보다 편하게 사용할 수 있도록 해주는 클래스의 집합

public class CollectionClass {
	public static void main(String[] args) {
		
//		Set 클래스
//		집합 - 중복을 허용하지 않고 순서가 없는 형태
//		순서가 없기에 index 사용 불가능
		
//		HashSet<E> : 중복을 허용하지 않고 순서가 없는 형태, 정렬x
		Set<Integer> integerSet = new HashSet<>();
		integerSet.add(4859);
		integerSet.add(459);
		integerSet.add(48);
		integerSet.add(859);
		integerSet.add(859);
		integerSet.add(32324859);
		
		Iterator<Integer> iterator = integerSet.iterator();
//		일반적으로 while문 씀
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
//		for-each도 됨
//		for (Integer item : integerSet) {
//			System.out.println(item);
//		}
		
//		TreeSet<E> : 중복을 허용하지 않고 순서가 없는 형태, 정렬o
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(4859);
		treeSet.add(459);
		treeSet.add(48);
		treeSet.add(859);
		treeSet.add(859);
		treeSet.add(32324859);
		
//		for (Integer item : treeSet) {
//			System.out.println(item);
//		}
		
		System.out.println("====================================================");
		
//		List	
//		데이터가 일렬로 나열한 구조
//		순서가 존재하고 중복이 허용 (배열)
		
//		ArrayList<E> : 순서가 존재하고 중복이 허용된 '배열'
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add(0, "banana");	// 추가하는 것
		
		list.set(0, "BaNaNa");	// 특정 index의 값을 바꿈
		
		String removeItem = list.remove(1);	// 반환을 해줌
		
		System.out.println(removeItem);
		System.out.println(list.toString()); // 배열 뽑아줌(잘 돌아가는지 확인)
		
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
//		LinkedList<E> : 순서가 존재하고 중복이 허용된 '배열' 
//						+ 각 요소가 이전 요소와 다음 요소의 주소를 같이 가지고 있음
//						검색속도가 빠름
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		long startTime = System.currentTimeMillis();
		for (int integer = 0; integer < 100_000; integer++) {
			arrayList.add(0, integer);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ArrayList 작업 시간 : " + (endTime - startTime));
		
//		↓ 더 빠름
		startTime = System.currentTimeMillis();
		for (int integer = 0; integer < 100_000; integer++) {
			linkedList.add(0, integer);
		}
		endTime = System.currentTimeMillis();
		System.out.println("LinkedList 작업 시간 : " + (endTime - startTime));
		
//		Map
//		key와 value가 하나의 쌍으로 저장되는 구조
//		순서가 존재하지 않음, 단 key를 사용해서 특정한 value를 가져올 수 있음
		
//		HashMap<Key, Value>
		Map<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("key", "value");
		hashMap.put("apple", "사과");
		
		System.out.println(hashMap.get("apple"));
		
//		Lotto 응용
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while (lotto.size() < 6) {
			Random random = new Random();
			int randomNumber = random.nextInt(45) + 1;
			lotto.add(randomNumber);
		}
		
		System.out.println(lotto.toString());
		
	}
}
