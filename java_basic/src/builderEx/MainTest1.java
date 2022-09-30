package builderEx;

public class MainTest1 {

	public static void main(String[] args) {
		
//		Student student = new Student();
		Student 홍길동 = new Student.Builder().setName("홍길동").build();
		System.out.println(홍길동);
		
		Student 이순신 = new Student.Builder()
				.setGrade(3)
				.setName("이순신")
				.build();
		System.out.println(이순신);
		
	}
}
