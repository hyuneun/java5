package pack4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JikwonMain {
	//다른클래스의 인자로 사용되는 람다
	//스테틱은 실행된다
	static ArrayList<Jikwon> jik = new ArrayList<>();
	static{
		jik.add(new Jikwon(3,"홍길동","111-1111"));
		jik.add(new Jikwon(2,"고길동","121-1111"));
		jik.add(new Jikwon(1,"공길동","113-1111"));
		
		System.out.println("정렬전 : " + jik);
	}
	public static void main(String[] args) {
		//1. 정렬 : 익명클래스 사용
		Collections.sort(jik, new Comparator<Jikwon>() {
			@Override
			public int compare(Jikwon o1, Jikwon o2) {
				return o1.bunho - o2.bunho;
			};
		});
		System.out.println("정렬후 : " + jik.toString());
		System.out.println();
		//2.람다 사용
		Collections.sort(jik, (o1,o2) -> o1.bunho - o2.bunho);
		System.out.println("정렬후 : " + jik.toString());
	}

}
