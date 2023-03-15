package chapter01.D_IO;

import java.util.Scanner;

// 입출력
// console을 통해서 개발자로부터 입력을 받을 때 Scanner 객체를 사용 함
// console로 데이터를 출력할 땐 System 객체를 사용 함


public class IO {

	public static void main(String[] args) {
//		출력
		String comment = "이것은 변수에 저장된 문자열입니다.";
		System.out.println("이것은 리터럴 상수 문자열입니다.");
		System.out.println(comment);
		
//		System.out.println(변수 or 상수)
//		변수 or 상수 자리에 어던 데이터 타입이 와도 됨
		float float1 = 1.15335645646456F;
		System.out.println(float1);
		
//		입력
		Scanner sc = new Scanner(System.in);
		System.out.println(sc);
//		Scanner 객체의 .next**(); 기능(메소드)를 사용해서 입력을 받을 수 있음
		int inputInteger = sc.nextInt();
		System.out.print("입력받은 값: ");
		System.out.println(inputInteger);
		
		sc.nextLine();
		
		String inputString = sc.nextLine();
		System.out.print("입력한 문자열: ");
		System.out.println(inputString);
	}

}
