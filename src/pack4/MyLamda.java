package pack4;

public class MyLamda {
	
	static class Inner implements Myinter{
		
		@Override
		public int addData(int a, int b) {
			
			return a+b;
		}
		
	}
	public static void main(String[] args) {
		Inner inner = new Inner();//전통적방식
		System.out.println(inner.addData(3, 4));
		
		System.out.println();
		Myinter myInter = (a, b) -> a + b;//람다
		System.out.println(myInter.addData(3, 4));
		System.out.println();
		Myinter mi = (a,b)-> a*b;
		System.out.println(mi.addData(3, 4));
	}

}
