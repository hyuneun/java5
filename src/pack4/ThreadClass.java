package pack4;

public class ThreadClass {
	public void sandData(String ss) {
		System.out.println(ss + "자료전송");
	}

	public ThreadClass() {
		m1();
		System.out.println();
		m2();
		System.out.println();
		m3();
		System.out.println();
		m4();
		System.out.println();
	}

	void m1() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sandData("m1");
				
			}
		}).start();
	}

	void m2() {//람다
		Thread th = new Thread(() -> sandData("m2"));
		th.start();
	}

	void m3() {//람다(더간결)
		new Thread(() -> sandData("m3")).start();
		
	}

	void m4() {//람다(더더간결(인터페이스사용))
		Runnable run = () -> sandData("m4");
		run.run();
				
	}

	public static void main(String[] args) {
		new ThreadClass();
	}

}
