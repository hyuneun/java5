package pack4;

public class MyintMain {

	public static void main(String[] args) {
		//ex1 전통적인방식
		Myint mi = new Myint(){
			public void abc() {
				System.out.println("인자가없는 추상메소드 오버라이드");
			}
		};
		mi.abc();
		
		//ex1 람다
		Myint a = () -> {
			System.out.println("인자가없는 추상메소드 오버라이드(람다)");	
		};//(세미콜론을 줘야함 하나의 그룹이기때문에)
		a.abc();
		System.out.println("___________________");
		
		//ex1 람다2
		Myint b = () -> {
			System.out.println("람다식으로 표현    |");
			System.out.println("복수의 문장수행    |");
		};
		b.abc();
		System.out.println("___________________");
		
		//ex2 전통적방식(인자있음)
		Myint2 c = new Myint2() {
			
			@Override
			public void abc(int a, int b) {
				System.out.println("합은 : " + (a+b));
				
			}
		};
		c.abc(5, 5);
		System.out.println("___________________");
		
		//ex2 람다(인자있음)
		Myint2 d = (x,y) -> {
			System.out.println("합은 : " + (x+y));
		};
		d.abc(5, 5);
		System.out.println("___________________");
		/*
		 * Myint2 d = (x) ->  System.out.println(x);
		 * 스테이먼트가하나일떄 중괄호{};를 빼도된다
		 * Myint2 d = x ->  System.out.println(x);
		 * 인자가 하나일때 ()생략
		 */
		
		//ex3 전통적방식(인자있음,리턴도잇음)
		Myint3 e = new Myint3() {
			
			@Override
			public int abc(int a, int b) {
				return a+b;
			}
		};
		System.out.println("합은 : " + e.abc(5, 5));
		System.out.println("___________________");
		//ex3 람다(인자있음,리턴도잇음)
		Myint3 f = (x,y) -> {
			return x + y;
		};
		//Myint3 f = (x,y) -> {x + y;}; 이렇게 줄일수있다
		System.out.println("합은 : " + f.abc(5, 5));
		System.out.println("___________________");
		
		
		
	}
}
