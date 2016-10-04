package pack5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream2 {

	public static void main(String[] args) {
		List<person> list = Arrays.asList(
				new person("홍길동", "남", 23),
				new person("신길동", "여", 55),
				new person("고길동", "남", 74),
				new person("고길동", "여", 34),
				new person("머길동", "남", 14)
				);
		
		//컬렉션 자료에 대한 중간/최종 처리
		double avg = list.stream().mapToInt(person :: getAge).average().getAsDouble();
		System.out.println("나이전체평균" + avg);
		
		double avgM = list.stream().filter(m -> m.getGender().equals("남")).mapToInt(person :: getAge).average().getAsDouble();
		System.out.println("남자나이평균" + avgM);
		
		System.out.println();
		list.stream().filter(a -> a.getName().startsWith("고")).forEach(a -> System.out.println(a.getName()));
		
		System.out.println();
		List<String> list2 = Arrays.asList("홍길동","고길동","홍길동","고길동","신길동");
		list2.stream().distinct().forEach(a -> System.out.println(a));
		
		System.out.println();
		list2.stream().sorted().forEach(a -> System.out.println(a));
		System.out.println();
		list2.stream().sorted(Comparator.reverseOrder()).forEach(a -> System.out.println(a));
	}
	static class person{
		private String name;
		private String gender;
		private int age;
		
		public person(String name, String gender, int age){
			this.name = name;
			this.gender = gender;
			this.age = age;
			
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		
	}
}
