package pack5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
	// Stream : 람다식을 기반으로 컬렉션,배열등에 대해 반복자역할을 한다.
	// 정렬,집계 처리등의 작업도 지원
	static int hap;
	public static void main(String[] args) {
		List<String> list = Arrays.asList("마우스","키보드","모니터");
		System.out.println(list.size());
		
		//Iterator
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String ss = iter.next();
			System.out.println(ss);	
		}
		System.out.println();
		//향상된for
		for(String s:list){
			System.out.println(s);
		}
		
		System.out.println();
		//Stream : 반복자처리(람다기반),병렬처리가능
		//내부 반복자 사용
		Stream<String> str = list.stream();
		str.forEach(System.out::println);//Consumer 함수적 인터페이스 사용	
		
		//컬렉션에서 스트림 얻기 - dto사용
		List<Student> list2 = Arrays.asList(
				new Student("홍길동",23),
				new Student("나길동",22),
				new Student("허길동",21)
				
		);
			Stream<Student> stream2 = list2.stream();
			stream2.forEach(s ->{
				System.out.println(s.getName());
			});
			
			System.out.println();
			//배열에서 스트림얻기
			String[] arr = {"봄","가을","여름","겨울"};
			Stream<String> arrs = Arrays.stream(arr);
			arrs.forEach(a -> System.out.println(a+ " "));
			
			System.out.println();
			IntStream inis = IntStream.range(1, 110000);
			//IntStream inis2 = IntStream.rangeClosed(1, 11); 10까지출력
			
			inis.forEach(a -> {
				System.out.println(a + " ");
				hap += a;
			});
			
			System.out.println("10까지의합 : " + hap);
	}

	static class Student {
		private String name;
		private int age;
		
		public Student(String name, int Age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return  name;
		}

		public int getAfe() {
			return  age;
		}
	}
}
