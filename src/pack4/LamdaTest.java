package pack4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

public class LamdaTest {
	//1.8 부터 지원
	public LamdaTest() {
		IntStream.range(1, 11).forEach((int value) -> System.out.println(value));
		//범위내 숫자값을리턴
		IntStream.range(10, 120).forEach(value -> System.out.println(value));
		
		System.out.println();//인자를 리턴할 경우엔 인자도 생략가능(::)
		IntStream.range(20, 50).forEach(System.out::println);
		
		System.out.println("\n");
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		
		//향상된 for로 컬렉션값출력
		for(Integer i:arr){
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		//람다로 출력 consumer타입 : 인자는있고 리턴은 없는 타입을 일컫는다
		arr.forEach( i ->{
			System.out.print(i);
			System.out.print(" ");
		});
	}

	public static void main(String[] args) {
		new LamdaTest();

	}

}
